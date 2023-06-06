package com.example.myapplication.di.base

import android.content.Context
import androidx.room.Room
import com.example.myapplication.data.local.PostEntity
import com.example.myapplication.data.local.PostsDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): PostsDataBase =
        Room
            .databaseBuilder(
            context,
            PostsDataBase::class.java,
            "posts_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideDao(db: PostsDataBase) = db.postsDao()

    @Provides
    fun provideEntity() = PostEntity()
}