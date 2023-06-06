package com.example.myapplication.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface PostsDao {
    @Query("SELECT * FROM PostEntity")
    suspend fun getAll(): List<PostEntity>?

    @Query("SELECT * FROM PostEntity WHERE id = :postId")
    suspend fun getPostById(postId: Long): PostEntity?

    @Insert
    suspend fun insert(postEntity: PostEntity?)

    @Update
    suspend fun update(postEntity: PostEntity?)

    @Delete
    suspend fun delete(postEntity: PostEntity?)
}