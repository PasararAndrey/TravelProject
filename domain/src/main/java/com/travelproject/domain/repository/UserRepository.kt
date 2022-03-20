package com.travelproject.domain.repository

import com.travelproject.domain.model.Result
import com.travelproject.domain.model.user.User
import com.travelproject.domain.model.user.UserLogin
import com.travelproject.domain.model.user.UserRegister

interface UserRepository {
    suspend fun createUser(user: UserRegister):Result<String>
    suspend fun login(user: UserLogin): Result<String>
    suspend fun logout(): Result<String>
    suspend fun getUser():Result<User>
}