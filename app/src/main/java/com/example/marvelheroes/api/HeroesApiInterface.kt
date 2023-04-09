package com.example.marvelheroes.api


import com.example.marvelheroes.models.Hero
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://www.simplifiedcoding.net/demos/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface HeroesApiInterface  {
    @GET("marvel")
    suspend fun getHeroesList(): List<Hero>
}

object HeroesApi {
    val retrofitInterface: HeroesApiInterface by lazy {
        retrofit.create(HeroesApiInterface::class.java)
    }
}
