package com.travelproject.domain.use_cases.user

import com.travelproject.domain.model.Result
import com.travelproject.domain.model.user.UserLogin
import com.travelproject.domain.repository.UserRepository
import javax.inject.Inject

class LoginUserUserCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(userLogin: UserLogin): Result<String> {
        return userRepository.login(userLogin)
    }
}