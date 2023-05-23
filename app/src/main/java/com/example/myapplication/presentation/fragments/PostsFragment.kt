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
import com.example.myapplication.databinding.FragmentPostsBinding
import com.example.myapplication.domain.models.DomainPost
import com.example.myapplication.presentation.adapters.AccountTransactionsAdapter
import com.example.myapplication.presentation.adapters.customItemDecoration.CustomItemDecoration
import com.example.myapplication.presentation.view_models.PostViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PostsFragment : Fragment() {
    private var _binding: FragmentPostsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PostViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPostsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observePosts()
    }

    private fun observePosts() {
        viewModel.postList.observe(viewLifecycleOwner) { posts ->
            initRecycler(posts)
        }
    }

    private fun initRecycler(posts: List<DomainPost>) {
        val customItemDecoration = CustomItemDecoration(requireContext())

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(customItemDecoration)
            adapter = AccountTransactionsAdapter(
                items = posts,
                event = {
                    findNavController().navigate(R.id.action_PostsFragment_to_AboutPostFragment)
                    }
                )
            }
    }
}