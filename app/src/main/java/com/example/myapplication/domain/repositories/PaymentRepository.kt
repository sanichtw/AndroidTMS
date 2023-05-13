package com.example.myapplication.domain.repositories

import com.example.myapplication.data.remote.dto.DataPaymentDto

interface PaymentRepository {
    fun getPayments(): List<DataPaymentDto>
    fun getPaymentInfo(): DataPaymentDto
}