package com.example.marvelheroes.models

data class Hero (
        val name: String,
        val realname: String,
        val team: String,
        val firstApperance: Int,
        val createdby: String,
        val publisher: String,
        val imageUrl: String,
        val bio: String
)