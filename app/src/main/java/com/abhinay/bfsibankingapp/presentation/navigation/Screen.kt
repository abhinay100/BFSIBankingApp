package com.abhinay.bfsibankingapp.presentation.navigation

/**
 * Created by Abhinay on 11/12/25.
 */
sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Accounts : Screen("accounts")
    object Transactions : Screen("transactions/{accountId}") {
        fun createRoute(accountId: String) = "transactions/{accountId}"
    }
}