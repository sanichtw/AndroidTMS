package com.example.myapplication.data.repository

import com.example.myapplication.data.remote.dto.DataPaymentDto
import com.example.myapplication.data.repository.remote.PaymentsRemoteImpl
import com.example.myapplication.domain.repositories.PaymentRepository

class PaymentsRepositoryImpl: PaymentRepository {
    override fun getPayments(): List<DataPaymentDto> = PaymentsRemoteImpl().getPayments()
    override fun getPaymentInfo(): DataPaymentDto = PaymentsRemoteImpl().getPaymentInfo()
}