package com.travelproject.data.repository

import com.travelproject.data.model.dto.toTravelPreview
import com.travelproject.data.remote.api.TravelApi
import com.travelproject.domain.model.TravelPreview
import com.travelproject.domain.repository.TravelRepository
import javax.inject.Inject

class TravelRepositoryImpl @Inject constructor(
    private val travelApi: TravelApi
) : TravelRepository {
    override suspend fun getTravelsPreviews(): List<TravelPreview> {
        return travelApi.getTravelPreviews().map {
            it.toTravelPreview()
        }
    }

}