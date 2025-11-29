package com.abhinay.bfsibankingapp.data.remote.dto

import com.google.gson.annotations.SerializedName

/**
 * Created by Abhinay on 29/11/25.
 */

data class TransferRequest(
    @SerializedName("fromAccountId") val fromAccountId: String,
    @SerializedName("toAccountId") val toAccountId: String,
    @SerializedName("amount") val amount: Double
)