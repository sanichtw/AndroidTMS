package com.example.myapplication.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.models.DomainPaymentList
import com.example.myapplication.domain.use_cases.PaymentsUseCase

class PaymentViewModel: ViewModel() {

    private val _paymentList = MutableLiveData<DomainPaymentList>()
    val paymentList: LiveData<DomainPaymentList> = _paymentList

    init {
        getPayments()
    }

    private fun getPayments() {
        _paymentList.value = PaymentsUseCase().getPayments()
    }
}