package com.example.marvelheroes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelheroes.databinding.HeroItemBinding
import com.example.marvelheroes.models.Hero

/*
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
}*/

class HeroesRVAdapter :
    ListAdapter<Hero, HeroesRVAdapter.HeroViewHolder>(DiffCallback) {

    class HeroViewHolder(private var binding: HeroItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(hero: Hero) {
            binding.hero = hero
            binding.executePendingBindings()
        }

    }

    companion object DiffCallback: DiffUtil.ItemCallback<Hero>() {
        override fun areItemsTheSame(oldItem: Hero, newItem: Hero): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Hero, newItem: Hero): Boolean {
            return oldItem.imageUrl == newItem.imageUrl
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