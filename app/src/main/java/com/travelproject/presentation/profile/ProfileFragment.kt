package com.travelproject.presentation.profile

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.travelproject.R
import com.travelproject.databinding.FragmentProfileBinding
import com.travelproject.domain.model.Result
import com.travelproject.utils.findNavControllerById
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private val profileViewModel: ProfileViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProfileBinding.bind(view)

        subscribeToProfileInfoEvents()
        profileViewModel.getUser()
        binding.logoutBtn.setOnClickListener {
            Log.d("logout", "logoutBtn pressed")
            profileViewModel.logout()
            findNavControllerById(R.id.fragment_container).navigate(R.id.action_mainFragment_to_loginFragment)
        }
    }


    private fun subscribeToProfileInfoEvents() = lifecycleScope.launch {
        profileViewModel.profileInfo.collect { result ->
            when (result) {
                is Result.Success -> {
                    hideProgressBar()
                    binding.userName.text = result.data?.name ?: "No Name"
                    binding.userEmail.text = result.data?.email ?: "No Email"
                }
                is Result.Error -> {
                    binding.userName.text = "No Name"
                    binding.userEmail.text = "No Email"
                    Snackbar.make(requireView(), result.errorMessage.toString(), Snackbar.LENGTH_SHORT).show()
                }
                is Result.Loading -> {
                    showProgressBar()
                }
            }
        }
    }



    private fun showProgressBar() {
        binding.profileProgressBar.isVisible = true
    }

    private fun hideProgressBar() {
        binding.profileProgressBar.isVisible = false
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}