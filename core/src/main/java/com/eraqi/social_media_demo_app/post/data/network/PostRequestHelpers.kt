package com.eraqi.social_media_demo_app.post.data.network

data class CreatePostRequest(
    val user: String,
    val content: String,
    val imageUrl: String?
)

data class UpdatePostRequest(
    val content: String?,
    val imageUrl: String?,
    val likes: Int?
)

data class DeleteResponse(
    val success: Boolean,
    val id: Int
)