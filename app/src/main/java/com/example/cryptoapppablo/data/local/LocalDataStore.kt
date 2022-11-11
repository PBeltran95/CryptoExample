package com.example.cryptoapppablo.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class LocalDataStore @Inject constructor(private val dataStore: DataStore<Preferences>) {


    companion object {
        val USERNAME = stringPreferencesKey("username")
        val PASSWORD = stringPreferencesKey("password")
    }

    suspend fun saveUserName(username: String) {
        dataStore.edit { settings ->
            settings[USERNAME] = username
        }
    }

    suspend fun savePassword(password: String) {
        dataStore.edit { settings -> settings[PASSWORD] = password }
    }

    suspend fun loadUserName(): Flow<String> = dataStore.data.map {
            preferences -> preferences[USERNAME] ?: ""
    }

    suspend fun loadPassword(): Flow<String> = dataStore.data.map {
            preferences -> preferences[PASSWORD] ?: ""
    }


}