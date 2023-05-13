package com.example.myapplication.domain.models

data class DomainPaymentList(
    val payments: List<DomainPayment> = emptyList()
)