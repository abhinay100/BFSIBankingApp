package com.abhinay.bfsibankingapp.domain.usecase

import com.abhinay.bfsibankingapp.domain.repository.BankingRepository
import javax.inject.Inject

/**
 * Created by Abhinay on 26/11/25.
 */
class GetTransactionsUseCase @Inject constructor(
    private val repository: BankingRepository
) {

    suspend operator fun invoke(accountId: String) =
         repository.getTransactions(accountId)
}