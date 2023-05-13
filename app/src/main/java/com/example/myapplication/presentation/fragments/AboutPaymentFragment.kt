package com.example.myapplication.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentDetailsBinding
import com.example.myapplication.domain.models.DomainPayment
import com.example.myapplication.presentation.view_models.AboutPaymentViewModel

class AboutPaymentFragment : Fragment() {
    private var viewModel: AboutPaymentViewModel? = null
    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(owner = this)[AboutPaymentViewModel::class.java]
        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDetailsInfo()
    }

    private fun initDetailsInfo() {
        val paymentInfo = viewModel?.paymentInfo?.value ?: DomainPayment()

        binding.apply {
            paymentAboutTitle.text = paymentInfo.title
            paymentAboutBody.text = paymentInfo.description
            paymentImage.setImageResource(paymentInfo.image)
        }
    }
}