package com.travelproject.data.repository

import com.travelproject.domain.model.TravelPreview
import com.travelproject.domain.repository.TravelRepository

class TravelRepositoryImpl : TravelRepository {
    override suspend fun getTravelsPreviews(): List<TravelPreview> {
        return listOf<TravelPreview>(
            TravelPreview(1, "Title", "https://www.industrialempathy.com/img/remote/ZiClJf-1920w.jpg")
        )
    }

}