package com.eraqi.social_media_demo_app.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.eraqi.social_media_demo_app.post.data.PostEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(postEntity: PostEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(users: List<PostEntity>)

    @Update
    suspend fun updatePost(user: PostEntity)

    @Query("DELETE FROM post WHERE id = :postId")
    suspend fun deletePostById(postId: Long)

    @Query("DELETE FROM post")
    suspend fun deleteAllPosts()

    @Query("SELECT * FROM post ORDER BY id DESC")
    fun getAllPosts(): List<PostEntity>

    @Query("SELECT * FROM post WHERE id = :postId LIMIT 1")
    suspend fun getPostById(postId: Long): PostEntity?
}
