package com.travelproject.domain.use_cases.user

import com.travelproject.domain.model.Result
import com.travelproject.domain.model.UserRegister
import com.travelproject.domain.repository.UserRepository
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(userRegister: UserRegister): Result<String> {
        return userRepository.createUser(userRegister)
    }

}
