package com.example.cryptoapppablo.core

import com.example.cryptoapppablo.data.model.CryptoMetadataResponse
import com.example.cryptoapppablo.data.model.StatusResponse
import com.google.gson.annotations.SerializedName

data class BaseResponse(
    val status: StatusResponse? = null,
    val data: List<CryptoMetadataResponse>? = null
)

