package com.example.myapplication.data.repository.local

import com.example.myapplication.data.local.PostEntity
import com.example.myapplication.data.local.PostsDao
import javax.inject.Inject

class PostsLocalImpl @Inject constructor(
    private val postsDao: PostsDao
): PostsLocal {
    override suspend fun getLocalPosts(): List<PostEntity>? = postsDao.getAll()

    override suspend fun insertPosts(postEntity: PostEntity) {
        postsDao.insert(postEntity = postEntity)
    }

    override suspend fun deletePost(postEntity: PostEntity) {
        postsDao.delete(postEntity = postEntity)
    }

    override suspend fun updatePost(postEntity: PostEntity) {
        postsDao.update(postEntity = postEntity)
    }

    override suspend fun getPostById(postId: Long): PostEntity? {
        return postsDao.getPostById(postId)
    }
}