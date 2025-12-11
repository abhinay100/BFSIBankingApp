package com.abhinay.bfsibankingapp.presentation.transactions

import com.abhinay.bfsibankingapp.domain.model.Transaction

/**
 * Created by Abhinay on 11/12/25.
 */

sealed class TransactionsUiState{
    object Loading : TransactionsUiState()
    data class Success(val transactions: List<Transaction>): TransactionsUiState()
    data class Error(val message: String): TransactionsUiState()

}