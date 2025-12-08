package com.abhinay.bfsibankingapp.presentation.login

/**
 * Created by Abhinay on 08/12/25.
 */
sealed class LoginUiState {
    object Idle: LoginUiState()
    object Loading: LoginUiState()
    object Success: LoginUiState()
    data class Error(val message: String): LoginUiState()
}