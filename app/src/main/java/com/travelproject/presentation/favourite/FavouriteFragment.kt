package com.travelproject.presentation.favourite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.travelproject.R
import com.travelproject.databinding.FragmentFavouriteBinding

class FavouriteFragment : Fragment(R.layout.fragment_favourite) {
    private var _binding: FragmentFavouriteBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFavouriteBinding.bind(view)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}

