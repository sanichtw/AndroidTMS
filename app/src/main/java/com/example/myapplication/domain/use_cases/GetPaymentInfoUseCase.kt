package com.example.myapplication.domain.use_cases

import com.example.myapplication.data.remote.dto.toDomainPayment
import com.example.myapplication.domain.repositories.PaymentRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetPaymentInfoUseCase @Inject constructor(
    private val paymentRepository: PaymentRepository
) {
    fun getPaymentInfo() = paymentRepository.getPaymentInfo().toDomainPayment()
}