package com.abhinay.bfsibankingapp.presentation.transactions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhinay.bfsibankingapp.domain.usecase.GetTransactionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Abhinay on 11/12/25.
 */
@HiltViewModel
class TransactionsViewModel @Inject constructor(
    private val getTransactionsUseCase: GetTransactionsUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow<TransactionsUiState>(TransactionsUiState.Loading)
    val uiState: StateFlow<TransactionsUiState> = _uiState.asStateFlow()

    fun loadTransactions(accountId: String){
        viewModelScope.launch {
            _uiState.value = TransactionsUiState.Loading
            getTransactionsUseCase(accountId).fold(
                onSuccess = { transactions ->
                    _uiState.value = TransactionsUiState.Success(transactions)

                },
                onFailure =  { error ->
                    _uiState.value = TransactionsUiState.Error(
                        error.message ?: "Failed to load transactions"
                    )

                }
            )
        }
    }

}