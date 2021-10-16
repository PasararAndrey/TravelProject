package com.travelproject.domain.repository

import com.travelproject.domain.model.TravelPreview

interface TravelRepository {

    fun getTravelsPreviews(): List<TravelPreview>


}