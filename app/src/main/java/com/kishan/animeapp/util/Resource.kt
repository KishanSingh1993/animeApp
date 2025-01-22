package com.kishan.animeapp.util

sealed class Resource<T>(val data: T?, val message: String?) {

    companion object {
        class Success<T>(data: T?) : Resource<T>(data, null)
        class Error<T>(message: String, data: T?) : Resource<T>(data, message)
        class Loading<T>(data: T?) : Resource<T>(data, null)
    }
}