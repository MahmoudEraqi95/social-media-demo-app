package com.eraqi.social_media_demo_app.post.data.network

import com.eraqi.social_media_demo_app.post.data.NetworkPost
import com.google.gson.JsonElement

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PostApi {

    @GET("posts")
    suspend fun getPosts(): Response<JsonElement>


    @GET("posts/since/{version}")
    suspend fun getPostsSince(
        @Path("version") version: Int
    ): List<NetworkPost>

    @POST("posts/sync")
    suspend fun syncPosts(
        @Body request: SyncRequest
    ): SyncResponse

    @POST("posts")
    suspend fun createPost(
        @Body post: CreatePostRequest
    ): NetworkPost

    // PUT /posts/:id
    @PUT("posts/{id}")
    suspend fun updatePost(
        @Path("id") id: Int,
        @Body post: UpdatePostRequest
    ): NetworkPost

    // DELETE /posts/:id
    @DELETE("posts/{id}")
    suspend fun deletePost(
        @Path("id") id: Int
    ): DeleteResponse
}