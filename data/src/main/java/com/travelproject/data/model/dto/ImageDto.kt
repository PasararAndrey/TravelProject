package com.travelproject.data.model.dto


import com.google.gson.annotations.SerializedName

data class ImageDto(
    @SerializedName("imageId")
    val imageId: Int,
    @SerializedName("imageName")
    val imageName: String
)