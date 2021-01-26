package com.example.newsapp


import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load


class BindingAdapters {

    companion object {
        @BindingAdapter("loadImageFromUrl")
        @JvmStatic
        fun loadImageFromUrl(imageView: ImageView, imageUrl: String) {
            imageView.load(imageUrl) {
                error(R.drawable.ic_error_image)
            }
        }

    }
}