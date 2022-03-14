package com.travelproject


import androidx.lifecycle.ViewModel
import com.travelproject.data.util.SessionManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val sessionManager: SessionManager
) : ViewModel() {


    private var token: String? = null

    private fun getJwtToken() {
        runBlocking {
            token = sessionManager.getJwtToken()
        }
    }

    init {
        getJwtToken()
    }

    fun isTokenExist(): Boolean {
        return token != null
    }

}