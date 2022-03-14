package com.travelproject.presentation.registration

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.travelproject.R
import com.travelproject.databinding.FragmentRegistrationBinding
import com.travelproject.domain.model.Result
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegistrationFragment : Fragment(R.layout.fragment_registration) {
    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!

    private val registrationViewModel: RegistrationViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRegistrationBinding.bind(view)
        binding.createAccountBtn.setOnClickListener {
            val name = binding.userNameEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val confirmPassword = binding.confirmPasswordEditText.text.toString()
            registrationViewModel.createUser(
                name.trim(),
                email.trim(),
                password.trim(),
                confirmPassword.trim()
            )
        }
        subscribeToRegisterEvents()
    }

    private fun subscribeToRegisterEvents() = lifecycleScope.launch {
        registrationViewModel.registerState.collect { result ->
            when (result) {
                is Result.Success -> {
                    hideProgressBar()
                    Snackbar.make(requireView(), "Account Created", Snackbar.LENGTH_SHORT).show()
                    val action = RegistrationFragmentDirections.actionRegistrationFragmentToMainFragment()
                    findNavController().navigate(action)
                }
                is Result.Error -> {
                    hideProgressBar()
                    Snackbar.make(requireView(), result.errorMessage.toString(), Snackbar.LENGTH_SHORT).show()
                }
                is Result.Loading -> {
                    showProgressBar()
                }
            }
        }
    }

    private fun showProgressBar() {
        binding.registrationProgressBar.isVisible = true
    }

    private fun hideProgressBar() {
        binding.registrationProgressBar.isVisible = false
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}