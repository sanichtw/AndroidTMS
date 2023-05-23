package com.example.myapplication.domain.models

data class DomainPost(
    val title: String? = "",
    val description: String? = "",
    val url: String? = "",
    val urlToImage: String? = "",
    val publishedAt: String? = ""
)