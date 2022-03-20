package com.travelproject.presentation.travelgeneral

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.travelproject.domain.model.travel.Travel
import com.travelproject.domain.use_cases.GetTravelByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TravelViewModel @Inject constructor(
    private val getTravelByIdUseCase: GetTravelByIdUseCase
) : ViewModel() {
    private var _travels = MutableLiveData<Travel>()
    val travels: LiveData<Travel>
        get() = _travels

    fun getTravelById(travelId: Int) {
        viewModelScope.launch {
            val travel = getTravelByIdUseCase(travelId)
            _travels.value = travel
        }
    }
}