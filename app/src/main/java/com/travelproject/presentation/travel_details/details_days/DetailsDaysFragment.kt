package com.travelproject.presentation.travel_details.details_days

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.travelproject.R
import com.travelproject.databinding.FragmentDetailsDaysBinding

class DetailsDaysFragment : Fragment(R.layout.fragment_details_days) {

    private var _binding: FragmentDetailsDaysBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDetailsDaysBinding.bind(view)
        val pager = binding.pagerDays
        val tabs = binding.tabsDays
        pager.adapter = DetailsDaysPagerAdapter(this@DetailsDaysFragment)

        TabLayoutMediator(tabs, pager) { tab, position ->
            tab.text = "day ${(position + 1)}"
        }.attach()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}