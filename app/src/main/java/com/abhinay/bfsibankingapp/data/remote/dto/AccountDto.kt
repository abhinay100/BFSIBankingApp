package com.abhinay.bfsibankingapp.data.remote.dto

import com.google.gson.annotations.SerializedName

/**
 * Created by Abhinay on 29/11/25.
 */
data class AccountDto(
    @SerializedName("id") val id: String,
    @SerializedName("accountNumber") val accountNumber: String,
    @SerializedName("accountType") val accountType: String,
    @SerializedName("balance") val balance: Double,
    @SerializedName("currency") val currency: String,
    @SerializedName("accountHolderName") val accountHolderName: String
)
