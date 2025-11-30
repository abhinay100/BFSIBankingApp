package com.abhinay.bfsibankingapp.data.repository

import com.abhinay.bfsibankingapp.data.local.AccountDao
import com.abhinay.bfsibankingapp.data.mapper.toDomain
import com.abhinay.bfsibankingapp.data.mapper.toEntity
import com.abhinay.bfsibankingapp.data.remote.BankingApiService
import com.abhinay.bfsibankingapp.data.remote.dto.TransferRequest
import com.abhinay.bfsibankingapp.domain.model.Account
import com.abhinay.bfsibankingapp.domain.model.Transaction
import com.abhinay.bfsibankingapp.domain.model.User
import com.abhinay.bfsibankingapp.domain.repository.BankingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.Result

/**
 * Created by Abhinay on 29/11/25.
 */
@Singleton
class BankingRepositoryImpl @Inject constructor(
    private val apiService: BankingApiService,
    private val accountDao: AccountDao
) : BankingRepository {

    private var authToken: String? = null

    override suspend fun login(
        email: String,
        password: String
    ): Result<User> {
        return try {
            val response = apiService.login()
            authToken = response.token
            Result.success(response.toUserDto().toDomain())

        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getAccounts(): Result<List<Account>> {
        return try {
            val accounts = apiService.getAccounts()
            accountDao.insertAccounts(accounts.map { it.toEntity() })
            Result.success(accounts.map { it.toDomain() })

        }catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getTransactions(accountId: String): Result<List<Transaction>> {
        return try{
            // Get all transactions and filter by accountId
            val allTransactions = apiService.getAllTransactions()
            val filteredTransactions = allTransactions
                .filter { it.accountId == accountId }
                .map { it.toDomain() }
            Result.success(filteredTransactions)

        }catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun transferMoney(
        fromAccountId: String,
        toAccountId: String,
        amount: Double
    ): Result<Boolean> {
       return try {
           val response = apiService.transferMoney(
               TransferRequest(fromAccountId, toAccountId, amount))
                       Result.success(response.success)

       }catch (e: Exception) {
           Result.failure(e)
       }
    }

    override fun getAccountsFlow(): Flow<List<Account>> {
        return accountDao.getAllAccounts().map { entities ->
              entities.map { it.toDomain() }
        }
    }

}