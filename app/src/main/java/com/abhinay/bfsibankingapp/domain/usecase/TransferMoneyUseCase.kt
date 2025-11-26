package com.abhinay.bfsibankingapp.domain.usecase

import com.abhinay.bfsibankingapp.domain.repository.BankingRepository
import javax.inject.Inject

/**
 * Created by Abhinay on 26/11/25.
 */
class TransferMoneyUseCase @Inject constructor(
    private val repository: BankingRepository
){
    suspend operator fun invoke(
       fromAccountId: String,
       toAccountId: String,
       amount: Double
    ) = repository.transferMoney(fromAccountId, toAccountId, amount)

}