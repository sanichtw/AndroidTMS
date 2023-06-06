package com.example.myapplication.data.repository

import com.example.myapplication.data.local.PostEntity
import com.example.myapplication.data.remote.dto.PostDto
import com.example.myapplication.data.remote.dto.toLocalPost
import com.example.myapplication.data.repository.local.PostsLocal
import com.example.myapplication.data.repository.remote.PostsRemote
import com.example.myapplication.domain.repositories.PostRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostsRepositoryImpl @Inject constructor(
    private val postsRemote: PostsRemote,
    private val postsLocal: PostsLocal
) : PostRepository {
    override suspend fun getPosts(): List<PostDto> {
        val remotePostList = postsRemote.getPosts().posts.orEmpty()

        if (remotePostList.isNotEmpty()) {
            remotePostList.forEach { postDto ->
                postsLocal.insertPosts(postEntity = postDto.toLocalPost())
            }
        }

        return remotePostList
    }
    override suspend fun getLocalPosts(): List<PostEntity> = postsLocal.getLocalPosts().orEmpty()
    override suspend fun getPostInfoFromLocal(postId: Long): PostEntity? {
        return postsLocal.getPostById(postId)
    }
}