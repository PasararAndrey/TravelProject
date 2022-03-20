package com.travelproject.domain.model.travel

data class Location(
    val location: LocationGeneral,
    val locationImages: List<TravelImage>
)

