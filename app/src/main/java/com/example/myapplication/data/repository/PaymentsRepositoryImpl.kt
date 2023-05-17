package com.example.myapplication.data.repository

import com.example.myapplication.data.remote.dto.DataPaymentDto
import com.example.myapplication.data.repository.remote.PaymentsRemote
import com.example.myapplication.domain.repositories.PaymentRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PaymentsRepositoryImpl @Inject constructor(
    private val paymentsRemote: PaymentsRemote
): PaymentRepository {
    override fun getPayments(): List<DataPaymentDto> = paymentsRemote.getPayments()
    override fun getPaymentInfo(): DataPaymentDto = paymentsRemote.getPaymentInfo()
}