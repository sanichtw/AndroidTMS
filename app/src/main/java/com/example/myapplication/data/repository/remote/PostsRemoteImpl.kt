package com.example.myapplication.data.repository.remote

import com.example.myapplication.data.remote.api.PostsApi
import com.example.myapplication.data.remote.dto.ResponseDto
import javax.inject.Inject


class PostsRemoteImpl @Inject constructor(
        private val postsApi: PostsApi
    ) : PostsRemote {
    override suspend fun getPosts(): ResponseDto =
        postsApi.getLatestNews()
}
