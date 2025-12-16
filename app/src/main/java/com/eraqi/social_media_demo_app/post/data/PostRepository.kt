package com.eraqi.social_media_demo_app.post.data

import android.preference.PreferenceDataStore
import com.eraqi.social_media_demo_app.db.daos.PostDao
import com.eraqi.social_media_demo_app.post.data.network.PostApi
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val postApi: PostApi,
    private val postDao: PostDao,
    private val dataStore: PreferenceDataStore
) {

    suspend fun getPosts(): List<Post> {
        sync()
        val result = postApi.getPosts().map { it.toPost() }
        return result
    }

    private fun sync() {

    }

    private suspend fun getLocalPost():List<PostEntity>{
        return postDao.getAllPosts()
    }
}
