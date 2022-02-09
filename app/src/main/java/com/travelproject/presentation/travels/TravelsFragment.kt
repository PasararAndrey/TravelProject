package com.travelproject.presentation.travels

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.travelproject.R
import com.travelproject.databinding.FragmentTravelsBinding
import com.travelproject.domain.model.TravelPreview
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TravelsFragment : Fragment(R.layout.fragment_travels) {
    private var _binding: FragmentTravelsBinding? = null
    private val binding get() = _binding!!

    private val travelViewModel: TravelsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTravelsBinding.bind(view)
        val mAdapter = TravelsAdapter(
            TravelsListener { travelId: Int ->
                val action = TravelsFragmentDirections.actionTravelsFragmentToTravelGeneralFragment().setTravelId(travelId)
                findNavController().navigate(action)
            })

        travelViewModel.apply {
            getTravels()
            travelsPreview.observe(viewLifecycleOwner,{
                mAdapter.submitList(it)
            })
        }

        binding.travelsList.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }




    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}