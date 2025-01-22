package com.kishan.animeapp.repository

import com.kishan.animeapp.data.ApiService
import com.kishan.animeapp.data.model.AnimeDetailsResponse
import com.kishan.animeapp.data.model.AnimeResponse
import retrofit2.Response

class AnimeRepository(private val apiService: ApiService) {

    suspend fun getTopAnime(): Response<AnimeResponse> {
        return apiService.getTopAnime()
    }

    suspend fun getAnimeDetails(id: Int): Response<AnimeDetailsResponse> {
        return apiService.getAnimeDetails(id)
    }

//    suspend fun getAnimeDetails(id: Int): Response<AnimeResponse> {
//        return api.getAnimeDetails(id) //
//    }
}
