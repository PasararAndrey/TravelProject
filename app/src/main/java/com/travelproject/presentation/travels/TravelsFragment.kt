package com.travelproject.presentation.travels

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.travelproject.R
import com.travelproject.databinding.FragmentTravelsBinding
import com.travelproject.domain.model.TravelPreview

class TravelsFragment : Fragment(R.layout.fragment_travels) {


    private var _binding: FragmentTravelsBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTravelsBinding.bind(view)
        val mAdapter = TravelsAdapter(
            TravelsListener { travelId: Int ->
                Toast.makeText(requireContext(), "${travelId} pressed", Toast.LENGTH_LONG).show()
            })


        binding.travelsList.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

        mAdapter.submitList(
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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}