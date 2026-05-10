package com.example.foods_ranking.presentation.viewmodel.auth

data class AuthUIState(
    val isLoggedIn: Boolean,
    val isLoading: Boolean,
    val error: Boolean,
    val errorMessage: Boolean
)