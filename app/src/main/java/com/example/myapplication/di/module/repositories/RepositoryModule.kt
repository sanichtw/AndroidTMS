package com.example.myapplication.di.module.repositories

import com.example.myapplication.data.repository.PostsRepositoryImpl
import com.example.myapplication.data.repository.local.PostsLocal
import com.example.myapplication.data.repository.remote.PostsRemote
import com.example.myapplication.domain.repositories.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providePostsRepository(postsRemote: PostsRemote, postsLocal: PostsLocal): PostRepository =
        PostsRepositoryImpl(postsRemote = postsRemote, postsLocal = postsLocal)
}