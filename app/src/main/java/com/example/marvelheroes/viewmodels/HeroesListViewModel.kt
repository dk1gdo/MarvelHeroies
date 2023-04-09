package com.example.marvelheroes.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelheroes.api.HeroesApi
import com.example.marvelheroes.models.Hero
import kotlinx.coroutines.launch

class HeroesListViewModel : ViewModel() {

    private val _heroes = MutableLiveData<List<Hero>>()

    val heroes: LiveData<List<Hero>> = _heroes
    init {
        getHeroes()
    }

    private fun getHeroes() {
        viewModelScope.launch {
            _heroes.value = HeroesApi.retrofitInterface.getHeroesList()
        }
    }
}