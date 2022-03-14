package com.travelproject.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.travelproject.domain.model.Result
import com.travelproject.domain.model.User
import com.travelproject.domain.use_cases.user.GetProfileInfoUseCase
import com.travelproject.domain.use_cases.user.LogoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getProfileInfoUseCase: GetProfileInfoUseCase,
    private val logoutUseCase: LogoutUseCase
) : ViewModel() {
    private val _profileInfo = MutableSharedFlow<Result<User>>()
    var profileInfo: SharedFlow<Result<User>> = _profileInfo

    fun getUser() = viewModelScope.launch {
        _profileInfo.emit(Result.Loading())
        _profileInfo.emit(getProfileInfoUseCase())
    }

    fun logout() = viewModelScope.launch {
        logoutUseCase()
    }
}