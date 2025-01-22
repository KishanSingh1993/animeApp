package com.kishan.animeapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kishan.animeapp.data.model.Anime
import com.kishan.animeapp.data.model.AnimeDetailsResponse
import com.kishan.animeapp.repository.AnimeRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class AnimeDetailViewModel(private val repository: AnimeRepository) : ViewModel() {
    val selectedAnime = MutableLiveData<Anime>()
    val errorMessage = MutableLiveData<String>()

    fun fetchAnimeDetails(id: Int) {
        viewModelScope.launch {
            try {
                val response: Response<AnimeDetailsResponse> = repository.getAnimeDetails(id)
                if (response.isSuccessful && response.body() != null) {
                    selectedAnime.postValue(response.body()!!.data) // Assign single Anime object
                } else {
                    errorMessage.postValue("Error: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                errorMessage.postValue("Network Error: ${e.message}")
            }
        }
    }
}
