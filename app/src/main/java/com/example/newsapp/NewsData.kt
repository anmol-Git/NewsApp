package com.example.newsapp


import com.google.gson.annotations.SerializedName

data class NewsData(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String
)