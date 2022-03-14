package com.travelproject.data.util

data class Response<T>(
    val success: Boolean,
    val message: T
)
