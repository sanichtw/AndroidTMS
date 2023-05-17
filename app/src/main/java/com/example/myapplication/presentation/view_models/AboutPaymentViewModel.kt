package com.example.myapplication.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.models.DomainPayment
import com.example.myapplication.domain.use_cases.GetPaymentInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AboutPaymentViewModel @Inject constructor(
    private val getPaymentInfoUseCase: GetPaymentInfoUseCase
): ViewModel() {

    private val _paymentInfo = MutableLiveData<DomainPayment>()
    val paymentInfo: LiveData<DomainPayment> = _paymentInfo

    init {
        getPaymentInfo()
    }

    private fun getPaymentInfo() {
        _paymentInfo.value = getPaymentInfoUseCase.getPaymentInfo()
    }
}