package com.example.newsapp


import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("author")
    val author: Any,
    @SerializedName("content")
    val content: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("urlToImage")
    val urlToImage: String
)