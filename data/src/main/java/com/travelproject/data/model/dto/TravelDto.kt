package com.travelproject.data.model.dto


import com.google.gson.annotations.SerializedName

data class TravelDto(
    @SerializedName("days")
    val days: List<DayDto>,
    @SerializedName("generalImages")
    val generalTravelImages: List<ImageDto>,
    @SerializedName("generalTravel")
    val generalTravelDto: GeneralTravelDto
)