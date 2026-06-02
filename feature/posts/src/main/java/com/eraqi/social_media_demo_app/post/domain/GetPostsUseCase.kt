package com.eraqi.social_media_demo_app.post.domain

import com.eraqi.social_media_demo_app.post.data.PostRepository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val repository: PostRepository
) {
    suspend operator fun invoke() = repository.getPosts()
}