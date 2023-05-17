package com.example.myapplication.di.module.repositories

import com.example.myapplication.data.repository.PaymentsRepositoryImpl
import com.example.myapplication.data.repository.remote.PaymentsRemote
import com.example.myapplication.domain.repositories.PaymentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providePaymentsRepository(paymentsRemote: PaymentsRemote): PaymentRepository =
        PaymentsRepositoryImpl(paymentsRemote = paymentsRemote)
}