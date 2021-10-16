package com.travelproject.presentation.travels

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.travelproject.R
import com.travelproject.data.repository.TravelRepositoryImpl
import com.travelproject.databinding.FragmentTravelsBinding
import com.travelproject.domain.model.TravelPreview
import com.travelproject.domain.use_cases.GetTravelPreviewsUseCase

class TravelsFragment : Fragment(R.layout.fragment_travels) {
    private var _binding: FragmentTravelsBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTravelsBinding.bind(view)
        val list = GetTravelPreviewsUseCase(TravelRepositoryImpl())()

        binding.travelsList.apply {
            adapter = TravelsAdapter(requireContext(), list) {
                val action = TravelsFragmentDirections.actionTravelsFragmentToTravelDetailsMainFragment()
                findNavController().navigate(action)
            }
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
    }

    private fun generateList(size: Int): ArrayList<TravelPreview> {
        val list = ArrayList<TravelPreview>()
        for (i in 0 until size) {
            val drawable = when (i % 4) {
                0 -> R.drawable.ic_launcher_background
                1 -> R.drawable.sample_image
                2 -> R.drawable.ic_launcher_background
                else -> R.drawable.sample_image
            }

            val item = TravelPreview(1, "Title", "drawable")

            list += item

        }
        return list
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}