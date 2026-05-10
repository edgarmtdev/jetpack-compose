package com.example.foods_ranking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.foods_ranking.presentation.navigation.AppNavigation
import com.example.foods_ranking.presentation.viewmodel.auth.AuthViewModel
import com.example.foods_ranking.ui.theme.Foods_RankingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val authViewModel: AuthViewModel = viewModel()
            val authState by authViewModel.authUIState.collectAsState()

            Foods_RankingTheme {
                AppNavigation(
                    authState = authState
                )
            }
        }
    }
}
