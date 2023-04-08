package com.example.marvelheroes.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelheroes.api.HeroesApi
import com.example.marvelheroes.models.Hero
import kotlinx.coroutines.launch

class HeroesListViewModel : ViewModel() {

    var heroes = mutableListOf<Hero>()
    private fun getHeroes() {
        viewModelScope.launch {
            heroes = HeroesApi.retrofitInterface.getHeroesList().toMutableList()
        }
    }
    init {
        getHeroes()

        heroes.forEach {
            Log.d("Init VM", it.name)
        }
        Log.d("Init VM", "end!")

    }
}