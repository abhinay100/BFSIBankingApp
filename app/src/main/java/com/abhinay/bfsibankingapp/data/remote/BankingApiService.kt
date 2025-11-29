package com.abhinay.bfsibankingapp.data.remote

import com.abhinay.bfsibankingapp.data.remote.dto.AccountDto
import com.abhinay.bfsibankingapp.data.remote.dto.LoginRequest
import com.abhinay.bfsibankingapp.data.remote.dto.LoginResponse
import com.abhinay.bfsibankingapp.data.remote.dto.TransactionDto
import com.abhinay.bfsibankingapp.data.remote.dto.TransferRequest
import com.abhinay.bfsibankingapp.data.remote.dto.TransferResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Created by Abhinay on 29/11/25.
 */

interface BankingApiService {

    @POST("api/auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @GET("api/accounts")
    suspend fun getAccounts(@Header("Authorization") token: String): List<AccountDto>

    @GET("api/accounts/{accountId}/transactions")
    suspend fun getTransactions(
        @Path("accountId") accountId: String,
        @Header("Authorization") token: String
    ): List<TransactionDto>

    @POST("api/transfer")
    suspend fun transferMoney(
        @Body request: TransferRequest,
        @Header("Authorization") token: String
    ): TransferResponse
}