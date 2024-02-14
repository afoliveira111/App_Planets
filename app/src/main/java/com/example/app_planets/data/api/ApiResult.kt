package com.example.app_planets.data.api

import java.lang.Exception

sealed class ApiResult<out T> {
    data class Success<T>(val data : T) : ApiResult<T>()
    data class Error(val exception: Exception) : ApiResult<Nothing>()

}