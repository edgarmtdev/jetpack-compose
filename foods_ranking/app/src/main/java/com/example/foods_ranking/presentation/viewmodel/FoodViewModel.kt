package com.example.foods_ranking.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.foods_ranking.domain.model.Food
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FoodViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        FoodUIState(
            foods = listOf(
                Food(1, "Pizza", 120, ""),
                Food(2, "Tacos", 10, ""),
                Food(3, "Hamburger", 130, "")
            )
        )
    )

    val uiState = _uiState.asStateFlow()
}