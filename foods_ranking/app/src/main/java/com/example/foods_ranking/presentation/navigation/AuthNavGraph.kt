package com.example.foods_ranking.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.foods_ranking.core.Routing
import com.example.foods_ranking.presentation.screens.auth.AuthScreen
import com.example.foods_ranking.presentation.viewmodel.auth.AuthUIState
import com.example.foods_ranking.presentation.viewmodel.auth.AuthViewModel

@Composable
fun AuthNavGraph(
    authViewModel: AuthViewModel,
    authUIState: AuthUIState
) {
    val navController =
        rememberNavController()

    NavHost(
    navController = navController,
    startDestination = Routing.LOGIN
    ) {
        composable(Routing.LOGIN) {
            AuthScreen(
                authViewModel = authViewModel,
                authUIState = authUIState
            )
        }
    }
}