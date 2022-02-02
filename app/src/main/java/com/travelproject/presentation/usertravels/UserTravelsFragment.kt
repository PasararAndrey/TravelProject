package com.travelproject.presentation.usertravels

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.travelproject.R
import com.travelproject.databinding.FragmentUserTravelsBinding

class UserTravelsFragment : Fragment(R.layout.fragment_user_travels) {
    private var _binding: FragmentUserTravelsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentUserTravelsBinding.bind(view)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}