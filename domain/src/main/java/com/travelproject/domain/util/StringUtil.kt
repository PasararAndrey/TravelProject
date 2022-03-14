package com.travelproject.domain.util

import com.travelproject.domain.util.Constants.MINIMUM_PASSWORD_LENGTH
import java.util.regex.Pattern

fun String.isEmailValid(): Boolean {
    val regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"
    val pattern = Pattern.compile(regex)
    return (this.isNotEmpty() && pattern.matcher(this).matches())
}

fun String.isPasswordValid(): Boolean {
    return (this.length > MINIMUM_PASSWORD_LENGTH)
}