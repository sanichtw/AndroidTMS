package com.example.myapplication.domain.use_cases

import com.example.myapplication.data.remote.dto.toDomainPost
import com.example.myapplication.domain.models.DomainPost
import com.example.myapplication.domain.repositories.PostRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostsUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend fun getPosts(): List<DomainPost> = postRepository.getPosts().map { postDto ->
        postDto.toDomainPost()
    }
}