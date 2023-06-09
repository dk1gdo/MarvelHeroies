package com.example.marvelheroes

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.marvelheroes.adapters.HeroesAdapter
import com.example.marvelheroes.models.Hero

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Hero>?) {
    val adapter = recyclerView.adapter as HeroesAdapter
    adapter.submitList(data)
}


@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imgUrl: String?){
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imageView.load(imgUri) {
            placeholder(android.R.drawable.ic_menu_gallery)
            error(android.R.drawable.stat_notify_error)
            transformations(RoundedCornersTransformation(50F))
        }
    }
}