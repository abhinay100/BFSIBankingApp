package com.abhinay.bfsibankingapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by Abhinay on 29/11/25.
 */

@Database(entities = [AccountEntity::class], version = 1, exportSchema = false)
abstract class BankingDatabase: RoomDatabase() {
    abstract fun accountDao(): AccountDao
}

