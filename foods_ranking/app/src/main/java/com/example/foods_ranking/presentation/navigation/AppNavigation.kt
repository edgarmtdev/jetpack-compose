package com.example.foods_ranking.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foods_ranking.core.Routing
import com.example.foods_ranking.presentation.screens.auth.AuthScreen
import com.example.foods_ranking.presentation.screens.food.FoodScreen
import com.example.foods_ranking.presentation.viewmodel.auth.AuthUIState

@Composable
fun AppNavigation(
    authState: AuthUIState
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,

        startDestination =
            when (authState) {
                is AuthUIState.Authenticated ->
                    Routing.HOME
                else ->
                    Routing.LOGIN
            }
    ) {
        composable(Routing.LOGIN) {
            AuthScreen()
        }
        composable(Routing.HOME) {
            FoodScreen()
        }
    }
}