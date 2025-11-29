package com.abhinay.bfsibankingapp.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Abhinay on 29/11/25.
 */
@Entity(tableName = "accounts")
data class AccountEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "account_number") val accountNumber: String,
    @ColumnInfo(name = "account_type") val accountType: String,
    @ColumnInfo(name = "balance") val balance: Double,
    @ColumnInfo(name = "currency") val currency: String,
    @ColumnInfo(name = "account_holder_name") val accountHolderName: String
)