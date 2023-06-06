package com.example.myapplication.data.repository.local

import com.example.myapplication.data.local.PostEntity

interface PostsLocal {
    suspend fun getLocalPosts(): List<PostEntity>?
    suspend fun insertPosts(postEntity: PostEntity)
    suspend fun deletePost(postEntity: PostEntity)
    suspend fun updatePost(postEntity: PostEntity)
    suspend fun getPostById(postId: Long): PostEntity?
}