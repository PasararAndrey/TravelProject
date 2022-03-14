package com.travelproject.data.remote.api

import com.travelproject.data.model.dto.TravelPreviewDto
import retrofit2.http.GET

interface TravelApi {

    @GET("travels")
    suspend fun getTravelPreviews() : List<TravelPreviewDto>
}