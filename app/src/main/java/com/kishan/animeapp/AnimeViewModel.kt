package com.kishan.animeapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kishan.animeapp.data.model.Anime
import com.kishan.animeapp.data.model.AnimeDetailsResponse
import com.kishan.animeapp.data.model.AnimeResponse
import com.kishan.animeapp.repository.AnimeRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class AnimeViewModel(private val repository: AnimeRepository) : ViewModel() {
    val animeList = MutableLiveData<List<Anime>>()
    val selectedAnime = MutableLiveData<Anime>()
    val errorMessage = MutableLiveData<String>()

    fun fetchTopAnime() {
        viewModelScope.launch {
            try {
                val response: Response<AnimeResponse> = repository.getTopAnime()
                if (response.isSuccessful && response.body() != null) {
                    animeList.postValue(response.body()!!.data ?: emptyList())
                } else {
                    errorMessage.postValue("Error: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                errorMessage.postValue("Network Error: ${e.message}")
            }
        }
    }

    fun fetchAnimeDetails(id: Int) {
        viewModelScope.launch {
            try {
                val response: Response<AnimeDetailsResponse> = repository.getAnimeDetails(id)
                if (response.isSuccessful && response.body() != null) {
                    selectedAnime.postValue(response.body()!!.data) // Directly assign single Anime object
                } else {
                    errorMessage.postValue("Error: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                errorMessage.postValue("Network Error: ${e.message}")
            }
        }
    }


//    fun fetchAnimeDetails(id: Int) {
//        viewModelScope.launch {
//            try {
//                val response: Response<AnimeResponse> = repository.getAnimeDetails(id)
//                if (response.isSuccessful && response.body() != null) {
//                    val animeList = response.body()!!.data
//                    if (animeList.isNotEmpty()) {
//                        selectedAnime.postValue(animeList[0]) // Select the first anime
//                    } else {
//                        errorMessage.postValue("Error: No anime data found.")
//                    }
//                } else {
//                    errorMessage.postValue("Error: ${response.errorBody()?.string()}")
//                }
//            } catch (e: Exception) {
//                errorMessage.postValue("Network Error: ${e.message}")
//            }
//        }
//    }

}
