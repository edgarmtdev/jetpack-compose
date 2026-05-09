package com.example.foods_ranking.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.foods_ranking.domain.model.Food
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FoodViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        FoodUIState(
            foods = listOf(
                Food(1, "Pizza", 120, "", false),
                Food(2, "Tacos", 10, "", false),
                Food(3, "Hamburger", 130, "", false)
            )
        )
    )

    val uiState = _uiState.asStateFlow()

    fun toggleLike(foodId: Int) {
        _uiState.update { currentState ->
            val updatedFoods = currentState.foods.map { food ->
                if (food.id == foodId) {
                    food.copy(
                        liked = !food.liked,
                        numberOfLikes =
                            if (!food.liked)
                                food.numberOfLikes + 1
                            else
                                food.numberOfLikes - 1
                    )
                } else {
                    food
                }
            }
            currentState.copy(
                foods = updatedFoods
            )
        }
    }
}