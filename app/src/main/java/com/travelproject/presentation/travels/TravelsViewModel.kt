package com.travelproject.presentation.travels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.travelproject.domain.model.TravelPreview
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TravelsViewModel @Inject constructor() : ViewModel() {
    private val _travelsPreview = MutableLiveData<List<TravelPreview>>(
        listOf(
            TravelPreview(1, "image_url", "Ukraine", 1),
            TravelPreview(2, "image_url", "USA", 2),
            TravelPreview(3, "image_url", "Ukraine", 3),
            TravelPreview(4, "image_url", "USA", 1),
            TravelPreview(5, "image_url", "USA", 2),
            TravelPreview(6, "image_url", "Russia", 3),
            TravelPreview(7, "image_url", "Ukraine", 4),
            TravelPreview(8, "image_url", "USA", 5),
            TravelPreview(9, "image_url", "Ukraine", 6),
            TravelPreview(1, "image_url", "Russia", 7),
            TravelPreview(10, "image_url", "Ukraine", 3),
            TravelPreview(11, "image_url", "Ukraine", 4),
            TravelPreview(12, "image_url", "Russia", 6),
            TravelPreview(13, "image_url", "Ukraine", 2),
            TravelPreview(14, "image_url", "USA", 2),
            TravelPreview(15, "image_url", "Ukraine", 2),
            TravelPreview(16, "image_url", "Russia", 2),
            TravelPreview(17, "image_url", "USA", 2),
            TravelPreview(18, "image_url", "Ukraine", 2),
            TravelPreview(19, "image_url", "Russia", 2),
        )

    )
    val travelsPreview: LiveData<List<TravelPreview>>
        get() = _travelsPreview


}