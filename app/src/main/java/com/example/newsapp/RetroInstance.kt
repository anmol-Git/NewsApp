package com.example.newsapp

import com.example.newsapp.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroInstance {

    private val retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    val api: SimpleApi by lazy { retrofit.create(SimpleApi::class.java) }
}