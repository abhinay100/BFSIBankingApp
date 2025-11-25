package com.abhinay.bfsibankingapp.domain.model
/**
 * Created by Abhinay on 25/11/25.
 */
data class Transaction(
    val id: String,
    val accountId: String,
    val amount: Double,
    val type: TransactionType,
    val description: String,
    val timeStamp: String,
    val balance: Double
)
