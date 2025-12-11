package com.abhinay.bfsibankingapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abhinay.bfsibankingapp.presentation.accounts.AccountsScreen
import com.abhinay.bfsibankingapp.presentation.login.LoginScreen

/**
 * Created by Abhinay on 11/12/25.
 */
@Composable
fun BankingNavHost(
    navController : NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Login.route) {inclusive = true}
                    }
                }
            )
        }

        composable(Screen.Accounts.route) {
            AccountsScreen(
                onAccountClick = { accountId ->
                    navController.navigate(Screen.Transactions.createRoute(accountId))
                }
            )

        }

    }

}