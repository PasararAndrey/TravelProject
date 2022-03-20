package com.travelproject.domain.use_cases.user

import com.travelproject.domain.model.Result
import com.travelproject.domain.model.user.User
import com.travelproject.domain.repository.UserRepository
import javax.inject.Inject

class GetProfileInfoUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke(): Result<User> = userRepository.getUser()

}