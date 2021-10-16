package com.travelproject.domain.use_cases

import com.travelproject.domain.model.TravelPreview
import com.travelproject.domain.repository.TravelRepository

class GetTravelPreviewsUseCase(private val travelRepository: TravelRepository) {
    operator fun invoke(): List<TravelPreview> {
        return travelRepository.getTravelsPreviews()
    }
}
