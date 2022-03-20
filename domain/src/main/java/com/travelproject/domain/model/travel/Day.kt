package com.travelproject.domain.model.travel

data class Day(
    val dayGeneral: DayGeneral,
    val dayImages: List<TravelImage>,
    val locations: List<Location>
)