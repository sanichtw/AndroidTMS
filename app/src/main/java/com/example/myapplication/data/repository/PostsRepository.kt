package com.example.myapplication.data.repository

import com.example.myapplication.data.remote.dto.PostDto

interface PostsRepository {
    suspend fun getPosts() : List<PostDto>?
}
