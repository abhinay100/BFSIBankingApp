package com.abhinay.bfsibankingapp.di

import android.content.Context
import androidx.room.Room
import com.abhinay.bfsibankingapp.data.local.AccountDao
import com.abhinay.bfsibankingapp.data.local.BankingDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Abhinay on 30/11/25.
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideBankingDatabase(@ApplicationContext context: Context): BankingDatabase {
        return Room.databaseBuilder(
            context,
            BankingDatabase::class.java,
            "banking_database"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideAccountDao(database: BankingDatabase): AccountDao {
        return database.accountDao()
    }

}