package com.example.myapplication.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.models.DomainPaymentList
import com.example.myapplication.domain.use_cases.PaymentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PaymentViewModel @Inject constructor(
    private val paymentsUseCase: PaymentsUseCase
): ViewModel() {

    private val _paymentList = MutableLiveData<DomainPaymentList>()
    val paymentList: LiveData<DomainPaymentList> = _paymentList

    init {
        getPayments()
    }

    private fun getPayments() {
        _paymentList.value = paymentsUseCase.getPayments()
    }
}