package com.example.foods_ranking.presentation.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.foods_ranking.presentation.viewmodel.auth.AuthUIState
import com.example.foods_ranking.presentation.viewmodel.auth.AuthViewModel

@Composable
fun AppNavigation(
    authViewModel: AuthViewModel,
    authUIState: AuthUIState
) {
    when(authUIState) {
        AuthUIState.Loading -> {
            Scaffold { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text("Loading...")
                }
            }
        }

        AuthUIState.Unauthenticated -> {
            AuthNavGraph(
                authViewModel = authViewModel,
                authUIState = authUIState
            )
        }

        is AuthUIState.Error -> {
            AuthNavGraph(
                authViewModel = authViewModel,
                authUIState = authUIState
            )
        }

        is AuthUIState.Authenticated -> {
            HomeNavGraph(
                authViewModel = authViewModel,
            )
        }
    }
}