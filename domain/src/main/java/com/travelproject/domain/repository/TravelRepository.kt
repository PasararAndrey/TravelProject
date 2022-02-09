package com.travelproject.domain.repository

import com.travelproject.domain.model.TravelPreview

interface TravelRepository {

    suspend fun getTravelsPreviews(): List<TravelPreview>


}