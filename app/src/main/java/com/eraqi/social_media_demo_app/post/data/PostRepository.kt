package com.eraqi.social_media_demo_app.post.data

import android.preference.PreferenceDataStore
import com.eraqi.social_media_demo_app.db.daos.PostDao
import com.eraqi.social_media_demo_app.post.data.network.CreatePostRequest
import com.eraqi.social_media_demo_app.post.data.network.PostApi
import com.eraqi.social_media_demo_app.post.data.network.SyncRequest
import com.eraqi.social_media_demo_app.post.data.network.SyncResponse
import com.eraqi.social_media_demo_app.post.data.network.UpdatePostRequest
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val postApi: PostApi,
    private val postDao: PostDao
) {

    suspend fun getPosts(): List<Post> {
        val result = postApi.getPosts().map { it.toPost() }
        return result
    }

    suspend fun syncSince(version: Int): List<NetworkPost> {
        return postApi.getPostsSince(version)
    }

    suspend fun createPost(
        user: String,
        content: String,
        imageUrl: String?
    ): NetworkPost {
        return postApi.createPost(
            CreatePostRequest(user, content, imageUrl)
        )
    }

    suspend fun updatePost(
        id: Int,
        content: String?,
        imageUrl: String?,
        likes: Int?
    ): NetworkPost {
        return postApi.updatePost(
            id,
            UpdatePostRequest(content, imageUrl, likes)
        )
    }

    suspend fun deletePost(id: Int) {
        postApi.deletePost(id)
    }

    suspend fun sync(
        created: List<NetworkPost>,
        updated: List<NetworkPost>,
        deleted: List<Int>
    ): SyncResponse {
        return postApi.syncPosts(
            SyncRequest(created, updated, deleted)
        )
    }


    private suspend fun getLocalPost():List<PostEntity>{
        return postDao.getAllPosts()
    }
}
