package com.example.cryptoapppablo.di

import com.example.cryptoapppablo.BuildConfig
import com.example.cryptoapppablo.data.remote.CryptoInterceptor
import com.example.cryptoapppablo.data.remote.CryptoWebService
import com.example.cryptoapppablo.repository.main.MainRepository
import com.example.cryptoapppablo.repository.main.MainRepositoryImpl
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    fun provideLoggInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    fun provideCryptoInterceptor(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().apply {
            addInterceptor(CryptoInterceptor())
            addInterceptor(loggingInterceptor)
        }.build()


    @Singleton
    @Provides
    fun providesRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()


    @Provides
    fun providesWebService(retrofit: Retrofit): CryptoWebService = retrofit.create(CryptoWebService::class.java)

    @Provides
    fun providesRemoteRepository(webService: CryptoWebService): MainRepository {
        return MainRepositoryImpl(webService)
    }



}