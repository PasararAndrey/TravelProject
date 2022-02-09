package com.travelproject.data.remote

import com.travelproject.data.remote.dto.TravelPreviewDto
import retrofit2.http.GET

interface TravelApi {

    @GET("travels")
    suspend fun getTravelPreviews() : List<TravelPreviewDto>
}