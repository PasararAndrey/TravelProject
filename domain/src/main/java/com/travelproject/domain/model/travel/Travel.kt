package com.travelproject.domain.model.travel

data class Travel(
    val days: List<Day>,
    val generalTravelImages: List<TravelImage>,
    val generalTravel: GeneralTravel
)