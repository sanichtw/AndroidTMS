package com.example.myapplication.di.module.repositories

import com.example.myapplication.data.repository.remote.PaymentsRemote
import com.example.myapplication.data.repository.remote.PaymentsRemoteImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RemoteRepositoryModule {

    @Provides
    fun providePaymentsRemote(): PaymentsRemote = PaymentsRemoteImpl()
}