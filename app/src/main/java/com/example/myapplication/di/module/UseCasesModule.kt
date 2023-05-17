package com.example.myapplication.di.module

import com.example.myapplication.domain.repositories.PaymentRepository
import com.example.myapplication.domain.use_cases.GetPaymentInfoUseCase
import com.example.myapplication.domain.use_cases.PaymentsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {
    @Provides
    fun providePaymentInfoUseCase(paymentRepository: PaymentRepository) =
        GetPaymentInfoUseCase(paymentRepository = paymentRepository)

    @Provides
    fun providePaymentUseCase(paymentRepository: PaymentRepository) =
        PaymentsUseCase(paymentRepository = paymentRepository)
}