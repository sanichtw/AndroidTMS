package com.example.myapplication.data

import com.example.myapplication.R
import com.example.myapplication.data.model.PaymentModel

open class PaymentsData {
    open fun getPayments() : List<PaymentModel> {
        val icon = R.drawable.transaction_icon

        return mutableListOf(
            PaymentModel(icon, "Mobile communication", "А1, MTS, Life"),
            PaymentModel(icon, "Banking, financial services", "Leasing, Insurance"),
            PaymentModel(icon, "Home improvement", "Household services"),
            PaymentModel(icon, "Tickets and lotteries", "Sports events"),
            PaymentModel(icon, "Internet, TV", "Hosting and domains"),
            PaymentModel(icon, "Utility bills", "Water and gas supply"),
            PaymentModel(icon, "Taxes", "Minsk, Brest, Mogilev"),
            PaymentModel(icon, "Other payments", "Beauty and health, fines"),
        )
    }
}