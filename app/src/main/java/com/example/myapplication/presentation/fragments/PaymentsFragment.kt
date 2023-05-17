package com.example.myapplication.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentPaymentsBinding
import com.example.myapplication.domain.models.DomainPaymentList
import com.example.myapplication.presentation.adapters.AccountTransactionsAdapter
import com.example.myapplication.presentation.adapters.customItemDecoration.CustomItemDecoration
import com.example.myapplication.presentation.view_models.PaymentViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PaymentsFragment : Fragment() {
    private var _binding: FragmentPaymentsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PaymentViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPaymentsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    private fun initRecycler() {
        val customItemDecoration = CustomItemDecoration(requireContext())
        val payments = viewModel.paymentList.value ?: DomainPaymentList()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(customItemDecoration)
            adapter = AccountTransactionsAdapter(
                payments,
                event = {
                    findNavController().navigate(R.id.action_PaymentsFragment_to_DetailsFragment)
                }
            )
        }
    }
}