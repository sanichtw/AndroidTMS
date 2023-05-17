package com.example.myapplication.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentDetailsBinding
import com.example.myapplication.domain.models.DomainPayment
import com.example.myapplication.presentation.view_models.AboutPaymentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutPaymentFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private val viewModel: AboutPaymentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDetailsInfo()
    }

    private fun initDetailsInfo() {
        val paymentInfo = viewModel.paymentInfo.value ?: DomainPayment()

        binding.apply {
            paymentAboutTitle.text = paymentInfo.title
            paymentAboutBody.text = paymentInfo.description
            paymentImage.setImageResource(paymentInfo.image)
        }
    }
}