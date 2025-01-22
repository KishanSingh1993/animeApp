package com.kishan.animeapp.data.model

data class AnimeDetail(
    val title: String,
    val synopsis: String?,
    val genres: List<Genre>,
    val episodes: Int?,
    val score: Double?,
    val trailer: Trailer?
)