package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapters.AccountTransactionsAdapter
import com.example.myapplication.adapters.customItemDecoration.CustomItemDecoration
import com.example.myapplication.databinding.FragmentRecyclerViewBinding
import com.example.myapplication.model.MyData


class RecyclerViewFragment : Fragment() {

    private var _binding: FragmentRecyclerViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val customItemDecoration = CustomItemDecoration(requireContext())
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(customItemDecoration)
            adapter = AccountTransactionsAdapter(listOfTransactions())
        }
    }

//    private fun listOfElements(): List<String> {
//        val data = mutableListOf<String>()
//        (1..50).forEach { i -> data.add("$i item") }
//        return data
//    }

    private fun listOfTransactions(): List<MyData> {
        val icon = R.drawable.transaction_icon

        return listOf(
            MyData(icon, "Mobile communication", "А1, MTS, Life"),
            MyData(icon, "Banking, financial services", "Leasing, Insurance"),
            MyData(icon, "Home improvement", "Household services"),
            MyData(icon, "Tickets and lotteries", "Sports events"),
            MyData(icon, "Internet, TV", "Hosting and domains"),
            MyData(icon, "Utility bills", "Water and gas supply"),
            MyData(icon, "Taxes", "Minsk, Brest, Mogilev"),
            MyData(icon, "Other payments", "Beauty and health, fines"),
        )
    }
}