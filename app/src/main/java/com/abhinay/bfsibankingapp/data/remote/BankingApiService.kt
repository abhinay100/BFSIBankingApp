package com.abhinay.bfsibankingapp.data.remote

import com.abhinay.bfsibankingapp.data.remote.dto.AccountDto
import com.abhinay.bfsibankingapp.data.remote.dto.LoginResponse
import com.abhinay.bfsibankingapp.data.remote.dto.TransactionDto
import com.abhinay.bfsibankingapp.data.remote.dto.TransferRequest
import com.abhinay.bfsibankingapp.data.remote.dto.TransferResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


/**
 * Created by Abhinay on 29/11/25.
 */

interface BankingApiService {

    // Get specific user
    @GET("users/{userId}")
    suspend fun login(@Path("userId") userId: String = "user_123"): LoginResponse

    // Get all accounts
    @GET("accounts")
    suspend fun getAccounts(): List<AccountDto>

    // Get all transactions
    // Note: My JSON Server doesn't support query filtering directly
    // We'll filter on the client side
    @GET("transactions")
    suspend fun getAllTransactions(): List<TransactionDto>

    // Create transfer
    @POST("transfers")
    suspend fun transferMoney(@Body request: TransferRequest): TransferResponse
}

/*
interface BankingApiService {

    @GET("users/user_123")
    suspend fun login(): LoginResponse

    @GET("accounts")
    suspend fun getAccounts(): List<AccountDto>

    @GET("transactions")
    suspend fun getTransactions(
        @Query("accountId") accountId: String
    ): List<TransactionDto>

    @POST("transfers")
    suspend fun transferMoney(@Body request: TransferRequest): TransferResponse

}*/
