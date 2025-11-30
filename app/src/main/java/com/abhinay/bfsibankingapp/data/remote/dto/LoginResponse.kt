package com.abhinay.bfsibankingapp.data.remote.dto

import com.google.gson.annotations.SerializedName

/**
 * Created by Abhinay on 29/11/25.
 */
// For login, MockAPI returns user directly
data class LoginResponse(
    @SerializedName("id") val userId: String,
    @SerializedName("token") val token: String,
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("phoneNumber") val phoneNumber: String
) {
    fun toUserDto() = UserDto(
        id = userId,
        name = name,
        email = email,
        phoneNumber = phoneNumber
    )
}
