package com.abhinay.bfsibankingapp.domain.usecase

import com.abhinay.bfsibankingapp.domain.repository.BankingRepository
import javax.inject.Inject

/**
 * Created by Abhinay on 26/11/25.
 */
class GetAccountsUseCase @Inject constructor(
       private val repository: BankingRepository
) {
    suspend operator fun invoke() = repository.getAccounts()
}