package com.example.myapplication.domain.use_cases

import com.example.myapplication.data.remote.dto.toDomainPaymentList
import com.example.myapplication.data.repository.PaymentsRepositoryImpl

class PaymentsUseCase {
    fun getPayments() = PaymentsRepositoryImpl().getPayments().toDomainPaymentList()
}