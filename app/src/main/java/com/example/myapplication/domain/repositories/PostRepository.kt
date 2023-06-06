package com.example.myapplication.domain.repositories

import com.example.myapplication.data.local.PostEntity
import com.example.myapplication.data.remote.dto.PostDto

interface PostRepository {
    suspend fun getPosts(): List<PostDto>
    suspend fun getLocalPosts(): List<PostEntity>
    suspend fun getPostInfoFromLocal(postId: Long): PostEntity?
}