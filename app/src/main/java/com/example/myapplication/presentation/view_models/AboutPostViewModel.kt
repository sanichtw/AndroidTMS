package com.example.myapplication.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.local.PostEntity
import com.example.myapplication.domain.use_cases.GetPostInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AboutPostViewModel @Inject constructor(
    private val getPostInfoUseCase : GetPostInfoUseCase
)  : ViewModel() {

    private val _postInfo = MutableLiveData<PostEntity>()
    val postInfo: LiveData<PostEntity> = _postInfo

    init {
        viewModelScope.launch {
            getPostInfo()
        }
    }

    private suspend fun getPostInfo() {
        _postInfo.value = getPostInfoUseCase.getPostInfo(3)
    }
}