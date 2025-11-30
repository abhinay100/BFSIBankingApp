package com.abhinay.bfsibankingapp.data.remote.dto

import com.google.gson.annotations.SerializedName

/**
 * Created by Abhinay on 29/11/25.
 */
data class TransferResponse(
    @SerializedName("id") val id: String,
    @SerializedName("success") val success: Boolean = true,
    @SerializedName("transactionId") val transactionId: String? = null
)