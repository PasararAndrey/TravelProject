package com.travelproject.data.model.dto


import com.google.gson.annotations.SerializedName

data class DayGeneralDto(
    @SerializedName("dayId")
    val dayId: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("order")
    val order: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("travelId")
    val travelId: Int
)

