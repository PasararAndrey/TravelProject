package com.travelproject.data.model.dto

import com.google.gson.annotations.SerializedName
import com.travelproject.domain.model.TravelPreview

data class TravelPreviewDto(
    @SerializedName("travelId")
    val travelId: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("country")
    val country: String
)

fun TravelPreviewDto.toTravelPreview(): TravelPreview {
    return TravelPreview(
        id = travelId,
        image = image,
        country = country
    )
}