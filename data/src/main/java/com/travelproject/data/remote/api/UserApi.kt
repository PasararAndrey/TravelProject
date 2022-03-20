package com.travelproject.data.remote.api

import com.travelproject.data.util.Constants.APPLICATION_JSON
import com.travelproject.data.util.Constants.AUTHORIZATION
import com.travelproject.data.util.Response
import com.travelproject.domain.model.user.User
import com.travelproject.domain.model.user.UserLogin
import com.travelproject.domain.model.user.UserRegister
import retrofit2.http.*

interface UserApi {

    @Headers(APPLICATION_JSON)
    @POST("/user/register")
    suspend fun createAccount(
        @Body user: UserRegister
    ): Response<String>

    @Headers(APPLICATION_JSON)
    @POST("/user/login")
    suspend fun login(
        @Body user: UserLogin
    ): Response<String>

    @Headers(APPLICATION_JSON)
    @GET("/user")
    suspend fun getUser(
        @Header(AUTHORIZATION) token:String
    ):Response<User>

}