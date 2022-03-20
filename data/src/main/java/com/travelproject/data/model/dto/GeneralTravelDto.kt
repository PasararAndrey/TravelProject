package com.travelproject.data.model.dto


import com.google.gson.annotations.SerializedName

data class GeneralTravelDto(
    @SerializedName("country")
    val country: String,
    @SerializedName("daysAmount")
    val daysAmount: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("previewImage")
    val previewImage: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("travelId")
    val travelId: Int,
    @SerializedName("userEmail")
    val userEmail: String
)