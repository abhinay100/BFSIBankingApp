package com.abhinay.bfsibankingapp.data.remote.dto

import com.google.gson.annotations.SerializedName

/**
 * Created by Abhinay on 29/11/25.
 */
data class LoginResponse(
    @SerializedName("userId") val userId: String,
    @SerializedName("token") val token: String,
    @SerializedName("user") val user: UserDto
)
