package com.example.foods_ranking.presentation.viewmodel

import com.example.foods_ranking.domain.model.Food

data class FoodUIState(
    val foods: List<Food> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)