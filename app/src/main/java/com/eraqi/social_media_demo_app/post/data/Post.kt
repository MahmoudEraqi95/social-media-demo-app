package com.eraqi.social_media_demo_app.post.data

import java.util.Date

data class Post(
    val id: String,
    val user: String,
    val content: String,
    val imageUrl: String? = null,
    val createdAt: Date,
    val updatedAt: Date
)

data class PostEntity(
    val id: String,
    val user: String,
    val content: String,
    val imageUrl: String? = null,
    val createdAt: Date,
    val updatedAt: Date,
    val deleted: Boolean = false
)



data class NetworkPost(
    val id: String,
    val user: String,
    val content: String,
    val imageUrl: String? = null,
    val createdAt: Date,
    val updatedAt: Date,
    val deleted: Boolean = false
)

fun NetworkPost.toPost(): Post{
    return Post(
        this.id,
        this.user,
        this.content,
        this.imageUrl,
        this.createdAt,
        this.updatedAt
    )
}