package com.example.myapplication.domain.repositories

import com.example.myapplication.data.remote.dto.PostDto

interface PostRepository {
    suspend fun getPosts(): List<PostDto>
}