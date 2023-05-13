package com.example.myapplication.data.repository.remote

import com.example.myapplication.data.remote.dto.DataPaymentDto

interface PaymentsRemote {
    fun getPayments() : List<DataPaymentDto>
    fun getPaymentInfo(): DataPaymentDto
}