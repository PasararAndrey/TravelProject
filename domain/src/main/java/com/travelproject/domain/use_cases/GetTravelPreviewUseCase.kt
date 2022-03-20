package com.travelproject.domain.use_cases

import com.travelproject.domain.model.TravelPreview
import com.travelproject.domain.repository.TravelRepository
import javax.inject.Inject

class GetTravelPreviewsUseCase @Inject constructor(
    private val travelRepository: TravelRepository
) {
    suspend operator fun invoke(): List<TravelPreview> = travelRepository.getTravelsPreviews()
}