package com.eraqi.social_media_demo_app.di

import android.content.Context
import androidx.room.Room
import com.eraqi.social_media_demo_app.db.AppDatabase
import com.eraqi.social_media_demo_app.db.daos.PostDao
import com.eraqi.social_media_demo_app.post.data.Post
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).build()

    @Provides
    fun providePostDao(db: AppDatabase): PostDao =
        db.postDao()
}