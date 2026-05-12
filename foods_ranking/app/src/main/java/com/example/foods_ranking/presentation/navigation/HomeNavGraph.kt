package com.example.foods_ranking.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.foods_ranking.core.Routing
import com.example.foods_ranking.presentation.screens.food.FoodScreen
import com.example.foods_ranking.presentation.viewmodel.auth.AuthUIState
import com.example.foods_ranking.presentation.viewmodel.auth.AuthViewModel

@Composable
fun HomeNavGraph(
    authViewModel: AuthViewModel,
) {
    val navController =
        rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routing.HOME
    ) {
        composable(Routing.HOME) {
            FoodScreen(
                authViewModel = authViewModel
            )
        }
    }
}