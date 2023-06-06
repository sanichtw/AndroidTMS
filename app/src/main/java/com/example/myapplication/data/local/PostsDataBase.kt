package com.example.myapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PostEntity::class], version = 2)
abstract class PostsDataBase: RoomDatabase() {
    abstract fun postsDao(): PostsDao
}