package com.travelproject.data.repository

import com.travelproject.data.remote.api.UserApi
import com.travelproject.data.util.Response
import com.travelproject.data.util.SessionManager
import com.travelproject.data.util.isNetworkConnected
import com.travelproject.domain.model.Result
import com.travelproject.domain.model.User
import com.travelproject.domain.model.UserLogin
import com.travelproject.domain.model.UserRegister
import com.travelproject.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userApi: UserApi,
    private val sessionManager: SessionManager
) : UserRepository {
    override suspend fun createUser(user: UserRegister): Result<String> {
        return try {
            if (!isNetworkConnected(sessionManager.context)) {
                Result.Error<String>("No Internet Connection!")
            }

            val result = userApi.createAccount(user)
            if (result.success) {
                sessionManager.saveJwtToken(result.message)
                Result.Success("User Created Successfully !")
            } else {
                Result.Error(result.message)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Error(e.message ?: "Some Problem Occurred!")
        }
    }

    override suspend fun login(user: UserLogin): Result<String> {
        return try {
            if (!isNetworkConnected(sessionManager.context)) {
                Result.Error<String>("No Internet Connection!")
            }
            val result = userApi.login(user)
            if (result.success) {
                sessionManager.saveJwtToken(result.message)
                Result.Success("Logged In Successfully !")
            } else {
                Result.Error(result.message)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Error(e.message ?: "Some Problem Occurred!")
        }
    }


    override suspend fun logout(): Result<String> {
        return try {
            sessionManager.logout()
            Result.Success("Logged Out Successfully!")
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Error(e.message ?: "Some Problem Occurred!")
        }
    }

    override suspend fun getUser(): Result<User> {
        return try {
            if (!isNetworkConnected(sessionManager.context)) {
                Result.Error<String>("No Internet Connection!")
            }
            val userToken = sessionManager.getJwtToken() ?: return Result.Error("Not Authorized")
            val result: Response<User> = userApi.getUser(
                "Bearer $userToken"
            )
            if (result.success) {
                Result.Success(result.message)
            } else {
                Result.Error(result.message.toString())
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Error(e.message ?: "Some Problem Occurred!")
        }
    }
}



