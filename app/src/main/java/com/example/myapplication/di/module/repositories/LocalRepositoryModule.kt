package com.example.myapplication.di.module.repositories

import com.example.myapplication.data.local.PostsDao
import com.example.myapplication.data.repository.local.PostsLocal
import com.example.myapplication.data.repository.local.PostsLocalImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class LocalRepositoryModule {

    @Provides
    fun providePostsLocal(postsDao: PostsDao): PostsLocal =
        PostsLocalImpl(postsDao = postsDao)
}