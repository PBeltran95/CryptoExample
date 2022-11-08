package com.example.cryptoapppablo.application

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.cryptoapppablo.core.Response

//fun Activity.handleApiError(failure: Response.Failure){
//    when {
//        failure.isNetworkError -> toast(this, "Check your internet connection")
//        failure.errorCode == 401 -> { toast(this, "Client failed to authenticate with the server") }
//        failure.errorCode == 404 -> { toast(this, "The resource you requested could not be found.") }
//        else -> toast(this, "Error: ${failure.errorBody}")
//    }
//}

fun Activity.toast(context: Context, text: String, longMessage: Boolean = true) {
    if (longMessage){
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
    }else{ Toast.makeText(context, text, Toast.LENGTH_SHORT).show()}
}