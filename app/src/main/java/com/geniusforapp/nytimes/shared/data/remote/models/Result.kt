package com.geniusforapp.nytimes.shared.data.remote.models

/**
 * @name nytimes
 * Copyrights (c) 2019-06-10 Created By Ahmad Najar
 **/
sealed class Result {
    object Loading : Result()
    class Success<T>(val data: T) : Result()
    class Error(val error: Throwable) : Result()
}