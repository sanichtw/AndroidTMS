package com.example.myapplication.di.module

import com.example.myapplication.domain.repositories.PostRepository
import com.example.myapplication.domain.use_cases.GetPostInfoUseCase
import com.example.myapplication.domain.use_cases.PostsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {
    @Provides
    fun providePostInfoUseCase(postRepository: PostRepository) =
        GetPostInfoUseCase(postRepository = postRepository)

    @Provides
    fun providePostsUseCase(postRepository: PostRepository) =
        PostsUseCase(postRepository = postRepository)
}