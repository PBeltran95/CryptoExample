package com.example.cryptoapppablo.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.cryptoapppablo.R
import com.example.cryptoapppablo.application.toast
import com.example.cryptoapppablo.core.Response
import com.example.cryptoapppablo.presentation.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.fetchAllCryptoCoins().observe(this) { response ->
            when(response){
                is Response.Loading -> {}
                is Response.Success -> {
                    Log.d("response", response.data.data?.joinToString(",") ?: "null")
                }
                is Response.Failure -> {
                    Log.e("response", response.e.message.toString(), response.e)
                    toast(this,response.e.message.toString())
                }
            }
        }
    }
}