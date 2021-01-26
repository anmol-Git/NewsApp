package com.example.newsapp

import retrofit2.Response

class repo {
    suspend fun getSimpleApi(country :String, apikey : String) : Response<NewsData>{
        return RetroInstance.api.getPost(country,apikey)
    }
}