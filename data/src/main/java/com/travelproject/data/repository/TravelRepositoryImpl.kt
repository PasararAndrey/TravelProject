package com.travelproject.data.repository

import com.travelproject.data.model.mappers.toTravel
import com.travelproject.data.model.mappers.toTravelPreview
import com.travelproject.data.remote.api.TravelApi
import com.travelproject.data.util.SessionManager
import com.travelproject.domain.model.TravelPreview
import com.travelproject.domain.model.travel.Travel
import com.travelproject.domain.repository.TravelRepository
import javax.inject.Inject

class TravelRepositoryImpl @Inject constructor(
    private val travelApi: TravelApi,
) : TravelRepository {
    override suspend fun getTravelsPreviews(): List<TravelPreview> {
        return travelApi.getTravelPreviews().map {
            it.toTravelPreview()
        }
    }

    override suspend fun getTravelById(travelId: Int): Travel {
        return travelApi.getTravelById(travelId).toTravel()
    }

}