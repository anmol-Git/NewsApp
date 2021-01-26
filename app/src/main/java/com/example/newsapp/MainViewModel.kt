package com.example.newsapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repo: repo) : ViewModel() {
    val myResponse : MutableLiveData<Response<NewsData>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            val response =repo.getSimpleApi("in","0a87ee8c072b4d09a2f695a1af815ded")
            myResponse.value =response
        }
    }
}