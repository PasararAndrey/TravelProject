package com.travelproject.data.remote.api

import com.travelproject.data.model.dto.TravelDto
import com.travelproject.data.model.dto.TravelPreviewDto
import com.travelproject.data.util.Constants.APPLICATION_JSON
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface TravelApi {

    @Headers(APPLICATION_JSON)
    @GET("travels")
    suspend fun getTravelPreviews(): List<TravelPreviewDto>

    @Headers(APPLICATION_JSON)
    @GET("travel/{id}")
    suspend fun getTravelById(
        @Path("id") travelId: Int
    ): TravelDto
}