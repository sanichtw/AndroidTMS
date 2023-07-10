package com.example.myapplication.presentation.fragments

import android.os.Bundle
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentPostsBinding
import com.example.myapplication.domain.models.DomainPost
import com.example.myapplication.presentation.adapters.PostsAdapter
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
        testUiThread()
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
            adapter = PostsAdapter(
                context = this@PostsFragment,
                items = posts,
                event = {
                    findNavController().navigate(R.id.action_PostsFragment_to_AboutPostFragment)
                }
            )
        }
    }

    private fun testUiThread() {
        val testRunnable = Runnable {
            try {
                Looper.prepare()

                val result = listOf("Test1", "Test2", "Test3").filter { el -> el == "Test3" }
                Toast.makeText(requireContext(), "$result", Toast.LENGTH_SHORT).show()

                Looper.loop()
            } catch (e: Exception) {
                throw e
            }
        }

        val testThread = Thread(testRunnable)
        testThread.start()
    }
}