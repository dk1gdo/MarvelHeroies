package com.example.marvelheroes.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.marvelheroes.HeroesRVAdapter
import com.example.marvelheroes.databinding.FragmentListHeroesBinding
import com.example.marvelheroes.viewmodels.HeroesListViewModel

class HeroesListFragment: Fragment() {

    private val viewModel: HeroesListViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*val view = inflater.inflate(R.layout.fragment_list_heroes, container, false)
        if (view is RecyclerView){

        }


        return view*/
        val binding = FragmentListHeroesBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.vm = viewModel
        binding.listHeroesFragment.adapter = HeroesRVAdapter()
        /*binding.listHeroesFragment.adapter =
            activity?.let { context?.let { it1 -> HeroesRVAdapter(it1, viewModel.heroes) } }*/

        return binding.root
    }
}