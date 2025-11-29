package com.abhinay.bfsibankingapp.data.mapper

import com.abhinay.bfsibankingapp.data.local.AccountEntity
import com.abhinay.bfsibankingapp.data.remote.dto.AccountDto
import com.abhinay.bfsibankingapp.data.remote.dto.TransactionDto
import com.abhinay.bfsibankingapp.data.remote.dto.UserDto
import com.abhinay.bfsibankingapp.domain.model.Account
import com.abhinay.bfsibankingapp.domain.model.AccountType
import com.abhinay.bfsibankingapp.domain.model.Transaction
import com.abhinay.bfsibankingapp.domain.model.TransactionType
import com.abhinay.bfsibankingapp.domain.model.User

/**
 * Created by Abhinay on 29/11/25.
 */

fun UserDto.toDomain() = User(
    id = id,
    name = name,
    email = email,
    phoneNumber = phoneNumber
)

fun AccountDto.toDomain() = Account(
    id = id,
    accountNumber = accountNumber,
    accountType = AccountType.valueOf(accountType),
    balance = balance,
    currency = currency,
    accountHolderName = accountHolderName
)

fun AccountDto.toEntity() = AccountEntity(
    id = id,
    accountNumber = accountNumber,
    accountType = accountType,
    balance = balance,
    currency = currency,
    accountHolderName = accountHolderName
)

fun AccountEntity.toDomain() = Account(
    id = id,
    accountNumber = accountNumber,
    accountType = AccountType.valueOf(accountType),
    balance = balance,
    currency = currency,
    accountHolderName = accountHolderName
)

fun TransactionDto.toDomain() = Transaction(
    id = id,
    accountId = accountId,
    amount = amount,
    type = TransactionType.valueOf(type),
    description = description,
    timestamp = timestamp,
    balance = balance
)


