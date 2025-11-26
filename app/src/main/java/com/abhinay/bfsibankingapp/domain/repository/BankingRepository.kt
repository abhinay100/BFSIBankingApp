package com.abhinay.bfsibankingapp.domain.repository

import com.abhinay.bfsibankingapp.domain.model.Account
import com.abhinay.bfsibankingapp.domain.model.Transaction
import com.abhinay.bfsibankingapp.domain.model.User
import kotlinx.coroutines.flow.Flow

/**
 * Created by Abhinay on 26/11/25.
 */
interface BankingRepository {
    suspend fun login(email: String, password: String): Result<User>
    suspend fun getAccounts(): Result<List<Account>>
    suspend fun getTransactions(accountId: String): Result<List<Transaction>>
    suspend fun transferMoney(fromAccountId: String, toAccountId: String, amount: Double): Result<Boolean>
    fun getAccountsFlow(): Flow<List<Account>>
}