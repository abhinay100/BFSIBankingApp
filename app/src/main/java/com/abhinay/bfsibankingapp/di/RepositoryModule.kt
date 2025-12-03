package com.abhinay.bfsibankingapp.di

import com.abhinay.bfsibankingapp.data.local.AccountDao
import com.abhinay.bfsibankingapp.data.remote.BankingApiService
import com.abhinay.bfsibankingapp.data.repository.BankingRepositoryImpl
import com.abhinay.bfsibankingapp.domain.repository.BankingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Abhinay on 30/11/25.
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideBankingRepository(
        apiService: BankingApiService,
        accountDao: AccountDao
    ): BankingRepository {
        return BankingRepositoryImpl(apiService, accountDao)
    }

}