package com.example.marvelheroes

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelheroes.databinding.HeroItemBinding
import com.example.marvelheroes.models.Hero

class HeroesRVAdapter :
    ListAdapter<Hero, HeroesRVAdapter.HeroViewHolder>(DiffCallback) {

    class HeroViewHolder(private var binding: HeroItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(hero: Hero) {
            binding.hero = hero
            Log.d("bindingInAdapter", hero.toString())
            binding.executePendingBindings()
        }

    }

    companion object DiffCallback: DiffUtil.ItemCallback<Hero>() {
        override fun areItemsTheSame(oldItem: Hero, newItem: Hero): Boolean {
            return true
        }

        override fun areContentsTheSame(oldItem: Hero, newItem: Hero): Boolean {
            return true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        return HeroViewHolder(HeroItemBinding.inflate(LayoutInflater.from(parent.context)))
    }
    override fun onBindViewHolder(holder: HeroViewHolder, position:Int) {
        val hero = getItem(position)
        holder.bind(hero)
    }

}