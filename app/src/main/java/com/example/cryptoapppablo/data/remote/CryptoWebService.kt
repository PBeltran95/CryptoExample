package com.example.cryptoapppablo.data.remote

import com.example.cryptoapppablo.core.BaseResponse
import retrofit2.http.GET

interface CryptoWebService {

    @GET("v1/cryptocurrency/listings/latest?limit=10")
    suspend fun getAllCoins(): BaseResponse
}