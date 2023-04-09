package com.example.marvelheroes.fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.marvelheroes.adapters.HeroesAdapter
import com.example.marvelheroes.databinding.FragmentListHeroesBinding
import com.example.marvelheroes.viewmodels.HeroesListViewModel

class HeroesListFragment: Fragment() {

    private val viewModel: HeroesListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListHeroesBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.vm = viewModel

        val listener = object : HeroesAdapter.ItemClickListener {
            override fun onItemClick(view: View?, position: Int) {
                viewModel.heroes.observe(viewLifecycleOwner) {
                    Toast.makeText(
                        activity,
                        "RealName: ${it[position].realname}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        val adapter = HeroesAdapter()
        adapter.setClickListener(listener)
        binding.listHeroesFragment.adapter = adapter
        return binding.root
    }
}