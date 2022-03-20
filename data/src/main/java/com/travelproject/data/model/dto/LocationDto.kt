package com.travelproject.data.model.dto


import com.google.gson.annotations.SerializedName

data class LocationDto(
    @SerializedName("location")
    val location: LocationGeneralDto,
    @SerializedName("locationImages")
    val locationImages: List<ImageDto>
)