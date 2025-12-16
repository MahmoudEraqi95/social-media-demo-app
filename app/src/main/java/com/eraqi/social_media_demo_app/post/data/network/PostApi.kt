package com.eraqi.social_media_demo_app.post.data.network

import com.eraqi.social_media_demo_app.post.data.NetworkPost
import retrofit2.http.GET

interface PostApi {

    @GET("posts")
    suspend fun getPosts(): List<NetworkPost>

    @GET("since")
    suspend fun since():List<NetworkPost>
}