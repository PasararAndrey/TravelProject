package com.travelproject.presentation.travels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.travelproject.domain.model.TravelPreview
import com.travelproject.domain.use_cases.GetTravelPreviewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TravelsViewModel @Inject constructor(
    private val getTravelPreviewsUseCase: GetTravelPreviewsUseCase
) : ViewModel() {
    private val _travelsPreview = MutableLiveData<List<TravelPreview>>(

    )
    val travelsPreview: LiveData<List<TravelPreview>>
        get() = _travelsPreview

    fun getTravels() {
        viewModelScope.launch {
            val travels = getTravelPreviewsUseCase.invoke()
            _travelsPreview.value = travels
        }
    }
}