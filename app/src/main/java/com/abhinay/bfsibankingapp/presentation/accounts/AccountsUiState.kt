package com.abhinay.bfsibankingapp.presentation.accounts

import com.abhinay.bfsibankingapp.domain.model.Account

/**
 * Created by Abhinay on 04/12/25.
 */
sealed class AccountsUiState {
    object Loading: AccountsUiState()
    data class Success(val accounts: List<Account>): AccountsUiState()
    data class Error(val message: String): AccountsUiState()
}