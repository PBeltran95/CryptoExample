package com.example.cryptoapppablo.core

import okhttp3.ResponseBody


sealed class Response<out T>{

    class Loading<out T>: Response<T>()
    data class Success<out T>(val data: T): Response<T>()
    data class Failure(val e: Throwable): Response<Nothing>()

}
