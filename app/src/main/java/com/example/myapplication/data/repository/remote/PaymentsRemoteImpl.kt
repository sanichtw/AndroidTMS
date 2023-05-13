package com.example.myapplication.data.repository.remote

import com.example.myapplication.R
import com.example.myapplication.data.remote.dto.DataPaymentDto

class PaymentsRemoteImpl : PaymentsRemote {
    override fun getPayments(): List<DataPaymentDto> {
        val icon = R.drawable.transaction_icon

        return mutableListOf(
            DataPaymentDto(1, "Mobile communication", "А1, MTS, Life", icon),
            DataPaymentDto(2, "Banking, financial services", "Leasing, Insurance", icon),
            DataPaymentDto(3, "Home improvement", "Household services", icon),
            DataPaymentDto(4, "Tickets and lotteries", "Sports events", icon),
            DataPaymentDto(5, "Internet, TV", "Hosting and domains", icon),
            DataPaymentDto(6, "Utility bills", "Water and gas supply", icon),
            DataPaymentDto(7, "Taxes", "Minsk, Brest, Mogilev", icon),
            DataPaymentDto(8, "Other payments", "Beauty and health, fines", icon),
        )}

    override fun getPaymentInfo(): DataPaymentDto =
        DataPaymentDto(
            1, "Mobile Development",
            "Text about the transaction",
            R.drawable.transaction_icon)
}