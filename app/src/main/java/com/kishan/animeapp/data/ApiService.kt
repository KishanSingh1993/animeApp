package com.kishan.animeapp.data

import com.kishan.animeapp.data.model.AnimeDetail
import com.kishan.animeapp.data.model.AnimeDetailsResponse
import com.kishan.animeapp.data.model.AnimeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("top/anime")
    suspend fun getTopAnime(): Response<AnimeResponse>

    @GET("anime/{id}")
    suspend fun getAnimeDetails(@Path("id") id: Int): Response<AnimeDetailsResponse>


}