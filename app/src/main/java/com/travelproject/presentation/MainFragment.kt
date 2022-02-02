package com.travelproject.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.travelproject.R
import com.travelproject.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)
        val bottomNavigationView = binding.bottomNavigation
        val navController = (childFragmentManager.findFragmentById(R.id.main_container_view) as NavHostFragment).navController
        NavigationUI.setupWithNavController(bottomNavigationView, navController)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}