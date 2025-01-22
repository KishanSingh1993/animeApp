package com.kishan.animeapp.ui.anime_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.kishan.animeapp.repository.AnimeRepository
import kotlinx.coroutines.Dispatchers

class AnimeDetailViewModel(private val repository: AnimeRepository) : ViewModel() {
    fun getAnimeDetails(animeId: Int) = liveData(Dispatchers.IO) {
        emit(repository.fetchAnimeDetails(animeId))
    }
}