package com.travelproject.domain.use_cases.user

import com.travelproject.domain.model.Result
import com.travelproject.domain.repository.UserRepository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke(): Result<String> {
        return userRepository.logout()
    }
}