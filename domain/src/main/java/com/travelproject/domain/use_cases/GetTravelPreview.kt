package com.travelproject.domain.use_cases

import com.travelproject.domain.model.TravelPreview
import javax.inject.Inject

class GetTravelPreviewsUseCase @Inject constructor() {
    suspend operator fun invoke(): List<TravelPreview> {
        return listOf(
            TravelPreview(1, "https://www.industrialempathy.com/img/remote/zicljf-1920w.jpg", "Ukraine"),
            TravelPreview(2, "https://www.industrialempathy.com/img/remote/zicljf-1920w.jpg", "USA"),
            TravelPreview(3, "https://www.industrialempathy.com/img/remote/zicljf-1920w.jpg", "Ukraine"),
            TravelPreview(4, "https://www.industrialempathy.com/img/remote/zicljf-1920w.jpg", "USA"),
            TravelPreview(5, "https://www.industrialempathy.com/img/remote/zicljf-1920w.jpg", "USA"),
            TravelPreview(6, "https://www.industrialempathy.com/img/remote/zicljf-1920w.jpg", "Russia"),
            TravelPreview(7, "https://www.industrialempathy.com/img/remote/zicljf-1920w.jpg", "Ukraine"),
            TravelPreview(8, "https://www.industrialempathy.com/img/remote/zicljf-1920w.jpg", "USA"),
            TravelPreview(9, "https://www.industrialempathy.com/img/remote/zicljf-1920w.jpg", "Ukraine"),
            TravelPreview(1, "https://www.industrialempathy.com/img/remote/zicljf-1920w.jpg", "Russia"),
            TravelPreview(10, "https://www.industrialempathy.com/img/remote/zicljf-1920w.jpg", "Ukraine"),
            TravelPreview(11, "https://www.industrialempathy.com/img/remote/zicljf-1920w.jpg", "Ukraine"),
            TravelPreview(12, "https://www.industrialempathy.com/img/remote/zicljf-1920w.jpg", "Russia"),
            TravelPreview(13, "https://www.industrialempathy.com/img/remote/zicljf-1920w.jpg", "Ukraine"),
            TravelPreview(14, "https://www.industrialempathy.com/img/remote/zicljf-1920w.jpg", "USA"),
            TravelPreview(15, "https://www.industrialempathy.com/img/remote/zicljf-1920w.jpg", "Ukraine"),
            TravelPreview(16, "https://www.industrialempathy.com/img/remote/zicljf-1920w.jpg", "Russia"),
            TravelPreview(17, "https://www.industrialempathy.com/img/remote/zicljf-1920w.jpg", "USA"),
            TravelPreview(18, "https://www.industrialempathy.com/img/remote/zicljf-1920w.jpg", "Ukraine"),
            TravelPreview(19, "https://www.industrialempathy.com/img/remote/zicljf-1920w.jpg", "Russia"),
        )
    }
}
