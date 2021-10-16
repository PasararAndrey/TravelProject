package com.travelproject.presentation.travel_details.details_main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.travelproject.R
import com.travelproject.databinding.FragmentDetailsMainBinding

class DetailsMainFragment : Fragment(R.layout.fragment_details_main) {
    private var _binding: FragmentDetailsMainBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDetailsMainBinding.bind(view)
        binding.apply {
            imageSlider.setSliderAdapter(
                DetailsMainSliderAdapter(
                    generateList(8)
                )
            )
            buttonDetailsDays.setOnClickListener {
                val action = DetailsMainFragmentDirections.actionTravelDetailsMainFragmentToDetailsDaysFragment()
                findNavController().navigate(action)
            }
        }
    }


    private fun generateList(size: Int): ArrayList<Int> {
        val list = ArrayList<Int>()
        for (i in 0 until size) {

            val item = when (i % 2) {
                0 -> R.drawable.sample_image
                else -> R.drawable.ic_launcher_background
            }
            list += item

        }
        return list
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}