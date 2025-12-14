package com.eraqi.social_media_demo_app.post.data

import androidx.compose.animation.scaleOut
import com.eraqi.social_media_demo_app.post.data.network.PostApi
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val postApi: PostApi
) {

    suspend fun getPosts(): List<Post> {
        val result = postApi.getPosts().map { it.toPost() }
        println(result)
        return result
    }
}
