package com.example.marvelheroes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.marvelheroes.fragments.HeroesListFragment
import com.example.marvelheroes.models.Hero

class HeroesRVAdapter(context: Context, private val heroes: List<Hero> ): RecyclerView.Adapter<HeroesRVAdapter.HeroesViewHolder?>() {

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
        val view: View = layoutInflater.inflate(R.layout.hero_item, parent, false)
        return HeroesViewHolder(view)
    }

    override fun getItemCount(): Int = heroes.size

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        holder.bind(heroes[position])
    }

    inner class HeroesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var imgView: ImageView = itemView.findViewById(R.id.imageView)
        private var heroName: TextView = itemView.findViewById(R.id.heroName)

        fun bind(item: Hero) {
            heroName.text = item.name
            val imageUri = item.imageUrl.toUri()
                .buildUpon()
                .scheme("https")
                .build()
            imgView.load(imageUri) {
                crossfade(true)
                placeholder(android.R.drawable.ic_media_previous)
                transformations(CircleCropTransformation())
            }
        }
    }
}