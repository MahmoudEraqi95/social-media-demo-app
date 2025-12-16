package com.eraqi.social_media_demo_app.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eraqi.social_media_demo_app.db.daos.PostDao
import com.eraqi.social_media_demo_app.post.data.PostEntity

@Database(
    entities = [PostEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}