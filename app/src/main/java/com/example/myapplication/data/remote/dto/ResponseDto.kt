package com.example.myapplication.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ResponseDto (
    @SerializedName("totalResults")
    val totalResults: Int,

    @SerializedName("articles")
    val posts: List<PostDto>?)