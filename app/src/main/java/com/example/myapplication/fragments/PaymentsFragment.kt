package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapters.AccountTransactionsAdapter
import com.example.myapplication.adapters.customItemDecoration.CustomItemDecoration
import com.example.myapplication.data.PaymentsData
import com.example.myapplication.databinding.FragmentPaymentsBinding


class PaymentsFragment : Fragment() {
    private var _binding: FragmentPaymentsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPaymentsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val customItemDecoration = CustomItemDecoration(requireContext())

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(customItemDecoration)
            adapter = AccountTransactionsAdapter(
                PaymentsData().getPayments(),
                event = {
                    findNavController().navigate(R.id.action_PaymentsFragment_to_DetailsFragment)
                }
                )
        }
    }
}