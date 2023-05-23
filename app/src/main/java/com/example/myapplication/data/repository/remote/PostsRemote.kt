package com.example.myapplication.data.repository.remote

import com.example.myapplication.data.remote.dto.ResponseDto

interface PostsRemote {
   suspend fun getPosts() : ResponseDto
}