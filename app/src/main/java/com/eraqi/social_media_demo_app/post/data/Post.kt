package com.eraqi.social_media_demo_app.post.data

import androidx.room.Entity
import androidx.room.PrimaryKey
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
    @PrimaryKey
    val id: String,
    val user: String,
    val content: String,
    val imageUrl: String? = null,
    val createdAt: String,
    val updatedAt: String,
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
        Date(this.createdAt),
        Date(this.updatedAt)
    )
}

sealed class PostListingResult{
    data class Success(val posts: List<Post>): PostListingResult()
    data class Error(val message: String): PostListingResult()

}