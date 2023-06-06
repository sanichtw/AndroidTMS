package com.example.myapplication.data.repository

import com.example.myapplication.data.local.PostEntity
import com.example.myapplication.data.remote.dto.PostDto

interface PostsRepository {
    suspend fun getPosts() : List<PostDto>?
    suspend fun getLocalPosts(): List<PostEntity>?
}
