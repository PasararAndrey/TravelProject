package com.travelproject.domain.repository

import com.travelproject.domain.model.TravelPreview
import com.travelproject.domain.model.travel.Travel

interface TravelRepository {

    suspend fun getTravelsPreviews(): List<TravelPreview>
    suspend fun getTravelById(travelId : Int):Travel

}