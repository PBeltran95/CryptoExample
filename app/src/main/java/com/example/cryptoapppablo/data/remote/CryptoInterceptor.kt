package com.example.cryptoapppablo.data.remote

import com.example.cryptoapppablo.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class CryptoInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("X-CMC_PRO_API_KEY", BuildConfig.API_KEY)
            .build()
        return chain.proceed(request)
    }
}