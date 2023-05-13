package com.example.myapplication.data.remote.dto

import com.example.myapplication.domain.models.DomainPayment
import com.example.myapplication.domain.models.DomainPaymentList


data class DataPaymentDto(
    val id: Int,
    val title: String? = null,
    val description: String? = null,
    val image: Int
    )

fun DataPaymentDto.toDomainPayment() = DomainPayment(
    id = id,
    title = title,
    description = description,
    image = image
)

fun List<DataPaymentDto>.toDomainPaymentList() = DomainPaymentList(
    this.map {
        it.toDomainPayment()
    }
)