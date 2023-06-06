package com.example.myapplication.domain.use_cases

import com.example.myapplication.domain.repositories.PostRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetPostInfoUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend fun getPostInfo(postId: Long) = postRepository.getPostInfoFromLocal(postId)
}