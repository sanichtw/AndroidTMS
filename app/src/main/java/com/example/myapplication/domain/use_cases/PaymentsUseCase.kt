package com.example.myapplication.domain.use_cases

import com.example.myapplication.data.remote.dto.toDomainPaymentList
import com.example.myapplication.domain.repositories.PaymentRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PaymentsUseCase @Inject constructor(
    private val paymentRepository: PaymentRepository
) {
    fun getPayments() = paymentRepository.getPayments().toDomainPaymentList()
}