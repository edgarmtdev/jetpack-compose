package com.example.foods_ranking.presentation.viewmodel.auth

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthViewModel: ViewModel() {

    private val _authUIState = MutableStateFlow<AuthUIState>(
        AuthUIState.Loading
    )

    val uiState = _authUIState.asStateFlow()
}