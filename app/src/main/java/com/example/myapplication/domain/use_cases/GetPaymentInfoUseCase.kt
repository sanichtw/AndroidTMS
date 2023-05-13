package com.example.myapplication.domain.use_cases

import com.example.myapplication.data.remote.dto.toDomainPayment
import com.example.myapplication.data.repository.PaymentsRepositoryImpl

class GetPaymentInfoUseCase {
    fun getPaymentInfo() = PaymentsRepositoryImpl().getPaymentInfo().toDomainPayment()
}