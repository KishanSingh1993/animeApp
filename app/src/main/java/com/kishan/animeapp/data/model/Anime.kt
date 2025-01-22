package com.kishan.animeapp.data.model


data class Anime(
    val mal_id: Int,
    val title: String,
    val episodes: Int?,
    val score: Double?,
    val synopsis: String,
    val images: Images,
    val trailer: Trailer?,
    val genres: List<Genre>,
    val characters: List<Character>
)