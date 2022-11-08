package com.example.cryptoapppablo.repository.main

import com.example.cryptoapppablo.core.BaseResponse
import com.example.cryptoapppablo.data.model.CryptoMetadataResponse

interface MainRepository {

    suspend fun getAllCryptos(): BaseResponse

}