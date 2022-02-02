package com.travelproject.presentation.travels

import com.travelproject.domain.model.TravelPreview

class TravelsListener(val clickListener: (travelId: Int) -> Unit) {
    fun onClick(travelPreview: TravelPreview) = clickListener(travelPreview.id)
}