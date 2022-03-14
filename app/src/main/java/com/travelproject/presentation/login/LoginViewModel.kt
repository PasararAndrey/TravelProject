package com.travelproject.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.travelproject.domain.model.Result
import com.travelproject.domain.model.UserLogin
import com.travelproject.domain.use_cases.user.LoginUserUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val loginUserUserCase: LoginUserUserCase
) : ViewModel() {
    private val _loginState = MutableSharedFlow<Result<String>>()
    val loginState: SharedFlow<Result<String>> = _loginState

    fun loginUser(
        email: String,
        password: String,
    ) = viewModelScope.launch {
        _loginState.emit(Result.Loading())
        if (email.isEmpty() || password.isEmpty()) {
            _loginState.emit(Result.Error("Some Fields are empty"))
            return@launch
        }
        val user = UserLogin(
            email, password
        )
        _loginState.emit(loginUserUserCase(user))
    }
}