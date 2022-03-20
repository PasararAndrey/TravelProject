package com.travelproject.presentation.travelgeneral

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.denzcoskun.imageslider.models.SlideModel
import com.travelproject.R
import com.travelproject.databinding.FragmentGeneralTravelBinding

class TravelGeneralFragment : Fragment(R.layout.fragment_general_travel) {
    private var _binding: FragmentGeneralTravelBinding? = null
    private val binding get() = _binding!!
    private val args: TravelGeneralFragmentArgs by navArgs()
    private val viewModel: TravelViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentGeneralTravelBinding.bind(view)
        viewModel.getTravelById(args.travelId)
        viewModel.travels.observe(viewLifecycleOwner) { travel ->
            binding.apply {
                country.text = travel.generalTravel.country
                title.text = travel.generalTravel.title
                daysAmount.text = travel.generalTravel.daysAmount.toString()
                description.text = travel.generalTravel.description
                val imageList = travel.generalTravelImages.map { travelImage -> SlideModel(travelImage.imageName) }
                imageSlider.setImageList(imageList)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}