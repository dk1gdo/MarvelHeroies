package com.example.marvelheroes.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelheroes.databinding.HeroItemBinding
import com.example.marvelheroes.models.Hero

class HeroesAdapter :
    ListAdapter<Hero, HeroesAdapter.HeroViewHolder>(DiffCallback) {

    private var iClickListener: ItemClickListener? = null

    inner class HeroViewHolder(private var binding: HeroItemBinding):
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        fun bind(hero: Hero) {
            binding.hero = hero
            Log.d("bindingInAdapter", hero.toString())
            binding.executePendingBindings()
        }
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
           iClickListener?.onItemClick(view, adapterPosition)

        }

    }

    companion object DiffCallback: DiffUtil.ItemCallback<Hero>() {
        override fun areItemsTheSame(oldItem: Hero, newItem: Hero): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Hero, newItem: Hero): Boolean {
            return oldItem.name == newItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        return HeroViewHolder(HeroItemBinding.inflate(LayoutInflater.from(parent.context)))
    }
    override fun onBindViewHolder(holder: HeroViewHolder, position:Int) {
        val hero = getItem(position)
        holder.bind(hero)
    }
    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }

    fun setClickListener(itemClickListener: ItemClickListener?) {
        iClickListener = itemClickListener
    }
}