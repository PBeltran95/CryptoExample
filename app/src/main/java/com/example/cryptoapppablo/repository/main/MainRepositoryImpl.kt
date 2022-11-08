package com.example.cryptoapppablo.repository.main

import com.example.cryptoapppablo.core.BaseResponse
import com.example.cryptoapppablo.data.model.CryptoMetadataResponse
import com.example.cryptoapppablo.data.remote.CryptoWebService
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val webService: CryptoWebService) : MainRepository {

    override suspend fun getAllCryptos(): BaseResponse {
        return webService.getAllCoins()
    }
}