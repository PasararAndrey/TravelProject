package com.travelproject.data.model.dto


import com.google.gson.annotations.SerializedName

data class LocationGeneralDto(
    @SerializedName("dayId")
    val dayId: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("locationId")
    val locationId: Int,
    @SerializedName("title")
    val title: String
)