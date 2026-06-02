package com.eraqi.social_media_demo_app.post.ui

import com.eraqi.social_media_demo_app.post.data.Post

sealed interface PostsUiState {
    object Loading : PostsUiState
    data class Success(val posts: List<Post>) : PostsUiState
    data class Error(val message: String) : PostsUiState
}