package com.travelproject.presentation.travelgeneral

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.travelproject.R
import com.travelproject.databinding.FragmentGeneralTravelBinding

class TravelGeneralFragment : Fragment(R.layout.fragment_general_travel) {
    private var _binding: FragmentGeneralTravelBinding? = null
    private val binding get() = _binding!!
    private val args: TravelGeneralFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentGeneralTravelBinding.bind(view)
        binding.title.text = args.travelId.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}