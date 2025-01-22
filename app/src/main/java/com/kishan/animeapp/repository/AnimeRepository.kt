package com.kishan.animeapp.repository

import com.kishan.animeapp.data.ApiService

class AnimeRepository(private val apiService: ApiService) {
    suspend fun fetchTopAnime() = apiService.getTopAnime()
    suspend fun fetchAnimeDetails(animeId: Int) = apiService.getAnimeDetails(animeId)
}