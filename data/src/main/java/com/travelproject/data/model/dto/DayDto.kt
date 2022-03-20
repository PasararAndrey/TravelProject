package com.travelproject.data.model.dto


import com.google.gson.annotations.SerializedName

data class DayDto(
    @SerializedName("day")
    val dayGeneral: DayGeneralDto,
    @SerializedName("dayImages")
    val dayImages: List<ImageDto>,
    @SerializedName("locations")
    val locations: List<LocationDto>
)