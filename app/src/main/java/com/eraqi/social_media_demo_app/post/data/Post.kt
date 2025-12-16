package com.eraqi.social_media_demo_app.post.data

import androidx.room.Entity
import java.util.Date

data class Post(
    val id: String,
    val user: String,
    val content: String,
    val imageUrl: String? = null,
    val createdAt: Date,
    val updatedAt: Date
)

@Entity("post")
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

internal fun NetworkPost.toPost(): Post{
    return Post(
        this.id,
        this.user,
        this.content,
        this.imageUrl,
        this.createdAt,
        this.updatedAt
    )
}

internal fun PostEntity.toPost(): Post{
    return Post(
        this.id,
        this.user,
        this.content,
        this.imageUrl,
        this.createdAt,
        this.updatedAt
    )
}