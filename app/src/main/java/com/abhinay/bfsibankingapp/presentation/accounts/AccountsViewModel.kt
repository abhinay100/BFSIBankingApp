package com.abhinay.bfsibankingapp.presentation.accounts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhinay.bfsibankingapp.domain.usecase.GetAccountsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Abhinay on 04/12/25.
 */
@HiltViewModel
class AccountsViewModel @Inject constructor(
    private val getAccountsUseCase: GetAccountsUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow<AccountsUiState>(AccountsUiState.Loading)
    val uiState: StateFlow<AccountsUiState> = _uiState.asStateFlow()

    init {
        loadAccounts()
    }

    fun loadAccounts() {
        viewModelScope.launch {
            _uiState.value = AccountsUiState.Loading
            getAccountsUseCase().fold(
                onSuccess = { accounts ->
                    _uiState.value = AccountsUiState.Success(accounts)
                },
                onFailure = { error ->
                    _uiState.value = AccountsUiState.Error(
                        error.message ?: "Unknown error occurred"
                    )

                }
            )
        }
    }

}