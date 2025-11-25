package com.abhinay.bfsibankingapp.domain.model

import android.icu.util.Currency

/**
 * Created by Abhinay on 25/11/25.
 */
data class Account(
    val id: String,
    val accountNumber: String,
    val accountType: AccountType,
    val balance: Double,
    val currency: String,
    val accountHolderName: String
)