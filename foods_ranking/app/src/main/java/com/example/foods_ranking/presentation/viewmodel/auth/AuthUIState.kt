package com.example.foods_ranking.presentation.viewmodel.auth

sealed interface AuthUIState {
    data object Loading: AuthUIState

    data object Unauthenticated: AuthUIState

    data class Authenticated(
        val userId: String
    ): AuthUIState

    data class Error(
        val message: String
    ) : AuthUIState
}