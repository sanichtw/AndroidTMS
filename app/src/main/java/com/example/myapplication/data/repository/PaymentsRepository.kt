package com.example.myapplication.data.repository

import com.example.myapplication.data.remote.dto.DataPaymentDto

interface PaymentsRepository {
    suspend fun getPayments() : List<DataPaymentDto>
}
