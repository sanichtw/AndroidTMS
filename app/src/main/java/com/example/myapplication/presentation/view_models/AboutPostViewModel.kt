package com.example.myapplication.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.models.DomainPost
import com.example.myapplication.domain.use_cases.GetPostInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AboutPostViewModel @Inject constructor(
    private val getPostInfoUseCase : GetPostInfoUseCase
)  : ViewModel() {

    private val _postInfo = MutableLiveData<DomainPost>()
    val postInfo: LiveData<DomainPost> = _postInfo

    init {
        getPostInfo()
    }

    private fun getPostInfo() {
//        _paymentInfo.value = getPostInfoUseCase.getPaymentInfo()
    }
}