package com.kishan.animeapp.ui.anime_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import com.kishan.animeapp.repository.AnimeRepository
import com.kishan.animeapp.util.Resource


class AnimeListViewModel(private val repository: AnimeRepository) : ViewModel() {
    fun getAnimeList() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(repository.fetchTopAnime().data))
        } catch (e: Exception) {
            emit(Resource.error("Error fetching anime list", null))
        }
    }
}