package com.travelproject.presentation.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.travelproject.domain.model.Result
import com.travelproject.domain.model.UserRegister
import com.travelproject.domain.use_cases.user.RegisterUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    val registerUserUseCase: RegisterUserUseCase
) : ViewModel() {
    private val _registerState = MutableSharedFlow<Result<String>>()
    val registerState: SharedFlow<Result<String>> = _registerState

    fun createUser(
        name: String,
        email: String,
        password: String,
        confirmPassword: String
    ) = viewModelScope.launch {
        _registerState.emit(Result.Loading())
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            _registerState.emit(Result.Error("Some Fields are empty"))
            return@launch
        }

        if (password != confirmPassword) {
            _registerState.emit(Result.Error("Passwords should be equal"))
        }


        val user = UserRegister(
            email,
            name,
            password
        )
        _registerState.emit(registerUserUseCase(user))
    }

}