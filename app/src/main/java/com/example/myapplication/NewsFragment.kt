package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // initialize the spinner and the listView
        initSpinner()
        initListView()

        binding.nextButton.setOnClickListener {
            findNavController().navigate(R.id.action_NewsFragment_to_RecyclerViewFragment)
        }
    }

    private fun initSpinner() {
        // creating an adapter
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.spinner_services,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // connecting the adapter and the spinner
        binding.spinner.adapter = adapter
    }

    private fun initListView() {
        // creating an adapter
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.listView_services,
            android.R.layout.simple_list_item_1
        )
        // connecting the adapter and the listView
        binding.listView.adapter = adapter
    }
}