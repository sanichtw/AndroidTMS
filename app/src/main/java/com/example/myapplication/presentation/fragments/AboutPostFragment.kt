package com.example.myapplication.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.databinding.FragmentAboutPostBinding
import com.example.myapplication.domain.models.DomainPost
import com.example.myapplication.presentation.view_models.AboutPostViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutPostFragment : Fragment() {
    private lateinit var binding: FragmentAboutPostBinding
    private val viewModel: AboutPostViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutPostBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDetailsInfo()
    }

    private fun initDetailsInfo() {
        val paymentInfo = viewModel.postInfo.value ?: DomainPost()

        binding.apply {
            paymentAboutTitle.text = paymentInfo.title
            paymentAboutBody.text = paymentInfo.description
//            paymentImage.setImageResource(paymentInfo.image)
        }
    }
}