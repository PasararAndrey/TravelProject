package com.travelproject.domain.use_cases

import com.travelproject.domain.repository.TravelRepository
import javax.inject.Inject

class GetTravelByIdUseCase @Inject constructor(
    private val travelRepository: TravelRepository
) {
    suspend operator fun invoke(travelId: Int) = travelRepository.getTravelById(travelId)
}

