package com.example.myapplication.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.myapplication.data.local.PostEntity
import com.example.myapplication.databinding.FragmentPostInfoBinding
import com.example.myapplication.presentation.view_models.AboutPostViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostInfoFragment : Fragment() {
    private lateinit var binding: FragmentPostInfoBinding
    private val viewModel: AboutPostViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPostInfoBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observePostInfo()
    }

    private fun observePostInfo() {
        viewModel.postInfo.observe(viewLifecycleOwner) { post ->
            initDetailsInfo(post)
        }
    }

    private fun initDetailsInfo(post: PostEntity) {
        binding.apply {
            postInfoTitle.text = post.title
            postInfoBody.text = post.description
        }
        Glide
            .with(this)
            .load(post.urlToImage)
            .into(binding.postInfoImage)

    }
}