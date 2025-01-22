package com.kishan.animeapp.data

import com.kishan.animeapp.data.model.AnimeDetail
import com.kishan.animeapp.data.model.AnimeResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("top/anime")
    suspend fun getTopAnime(): AnimeResponse

    @GET("anime/{anime_id}")
    suspend fun getAnimeDetails(@Path("anime_id") animeId: Int): AnimeDetail
}