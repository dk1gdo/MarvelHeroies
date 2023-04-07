package com.example.marvelheroes.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelheroes.api.HeroesApi
import com.example.marvelheroes.models.Hero
import kotlinx.coroutines.launch

class HeroesListViewModel : ViewModel() {

    var _heroes = mutableListOf<Hero>()
    private fun getHeroes() {
        viewModelScope.launch {
            _heroes = HeroesApi.retrofitInterface.getHeroesList().toMutableList()
        }
    }
    init {
        getHeroes()
    }
}