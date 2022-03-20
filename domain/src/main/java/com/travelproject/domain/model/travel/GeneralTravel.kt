package com.travelproject.domain.model.travel

data class GeneralTravel(
    val country: String,
    val daysAmount: Int,
    val description: String,
    val previewImage: String,
    val title: String,
    val travelId: Int,
    val userEmail: String
)