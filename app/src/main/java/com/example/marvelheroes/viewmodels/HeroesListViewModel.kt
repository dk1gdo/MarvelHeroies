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

    var oneHero = Hero(
        "Captain America",
        "Steve Rogers",
        "Avengers",
        1941,
        "Joe Simon",
        "Marvel Comics",
        "https://www.simplifiedcoding.net/demos/marvel/captainamerica.jpg",
        "\r\n\t\tSteven Rogers was born in the Lower East Side of Manhattan, New York City, in 1925 to poor Irish immigrants, Sarah and Joseph Rogers.[54] Joseph died when Steve was a child, and Sarah died of pneumonia while Steve was a teen. By early 1940, before America's entry into World War II, Rogers is a tall, scrawny fine arts student specializing in illustration and a comic book writer and artist.\r\n\t\t"
    )

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