package com.example.cryptoapppablo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.cryptoapppablo.core.Response
import com.example.cryptoapppablo.repository.main.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val remoteRepository: MainRepository) : ViewModel()  {

    fun fetchAllCryptoCoins() = liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
        emit(Response.Loading())
        try {
            emit(Response.Success(remoteRepository.getAllCryptos()))
        }catch (e:Exception){
            emit(Response.Failure(e))
        }
    }

}