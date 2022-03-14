package com.travelproject.data.util

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.travelproject.data.util.Constants.JWT_TOKEN_KEY
import kotlinx.coroutines.flow.first

class SessionManager(val context: Context) {


    private val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = "session_manager")

    suspend fun saveJwtToken(token: String) {
        val jwtTokenKey = stringPreferencesKey(JWT_TOKEN_KEY)
        context.datastore.edit { preferences ->
            preferences[jwtTokenKey] = token
        }
    }


    suspend fun getJwtToken(): String? {
        val jwtTokenKey = stringPreferencesKey(JWT_TOKEN_KEY)
        val preferences = context.datastore.data.first()
        Log.d("SessionManager", "preferences[jwtTokenKey] - ${preferences[jwtTokenKey]}")
        return preferences[jwtTokenKey]
    }

    suspend fun logout() {
        Log.d("logout", "logout in session manager started")
        context.datastore.edit { preferences ->
            Log.d("logout", "Before logout - ${preferences[stringPreferencesKey(JWT_TOKEN_KEY)]}")
            preferences.clear()
            Log.d("logout", "After logout - ${preferences[stringPreferencesKey(JWT_TOKEN_KEY)]}")
        }
    }
}