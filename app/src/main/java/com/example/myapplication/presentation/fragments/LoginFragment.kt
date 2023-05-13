package com.example.myapplication.presentation.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find buttons by id
        val loginButton = binding.loginButton
        val passwordInput = binding.passwordInput
        loginButton.isEnabled = false

        // Set the listener to the login button
        loginButton.setOnClickListener {
            if (loginButton.isEnabled) {
                findNavController().navigate(R.id.action_LoginFragment_to_PaymentsFragment)
            }
        }

        // Tracking text changes in the password input
        passwordInput.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            
            override fun afterTextChanged(s: Editable) {
                val password = passwordInput.text.toString()

                // We check whether the password meets the specified conditions and if
                // the password is valid, make the button active
                loginButton.isEnabled = isValidPassword(password)
            }

            private val isValidPassword = {password: String -> password.length >= 8 }
        })
    }
}