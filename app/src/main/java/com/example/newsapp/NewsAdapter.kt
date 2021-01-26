package com.example.newsapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.ItemViewBinding

class NewsAdapter(private val listener:NewsItemClicked) : RecyclerView.Adapter<NewsViewHolder>() {
       private var item = ArrayList<Article>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currNews =item[position]
        holder.bind(currNews)
        holder.itemView.setOnClickListener {
            listener.onItemClicked(currNews)
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }
     fun updateNews(updated: NewsData){
         item.clear()
        for (i in updated.articles){
            item.add(i)
        }
         notifyDataSetChanged()
     }
}

class NewsViewHolder(private val binding :ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind (article: Article?){
        binding.article= article
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup) :NewsViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding =ItemViewBinding.inflate(layoutInflater,parent,false)
            return NewsViewHolder(binding)
        }
    }
}

interface NewsItemClicked{
    fun onItemClicked(item: Article)
}