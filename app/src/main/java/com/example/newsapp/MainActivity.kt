package com.example.newsapp

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), NewsItemClicked {
    private  lateinit  var mAdapter: NewsAdapter
    private lateinit var viewModel: MainViewModel
    private lateinit var repo: repo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         repo =repo()

        val  viewModelFactory = viewModelFactory(repo)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        val recycle=findViewById<RecyclerView>(R.id.recyclerView)
         recycle.layoutManager=LinearLayoutManager(this)
       mAdapter=NewsAdapter(this)
        recycle.adapter=mAdapter
        viewModel.getPost()
        viewModel.myResponse.observe(this, { response ->
                 if (response.isSuccessful){
                      Log.d("response is ", response.body().toString())
                       response.body()?.let { mAdapter.updateNews(it) }
                 }
        })
    }
    override fun onItemClicked(item: Article) {
  val builder=CustomTabsIntent.Builder()
        val customTabsIntent=builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(item.url))
    }
}