package com.example.foods_ranking.presentation.viewmodel.food

import androidx.lifecycle.ViewModel
import com.example.foods_ranking.domain.model.Food
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FoodViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        FoodUIState(
            foods = listOf(
                Food(
                    1,
                    "Pizza",
                    description = "An example text...",
                    1,
                    "https://images.pexels.com/photos/31596394/pexels-photo-31596394.jpeg?_gl=1*9hocsg*_ga*MTMwMTQ0MjI5NC4xNzc4NDI0Mjg0*_ga_8JE65Q40S6*czE3Nzg0MjQyODMkbzEkZzEkdDE3Nzg0MjQyOTMkajUwJGwwJGgw",
                    false,
                ),
                Food(
                    2,
                    "Tacos",
                    description = "An example text...",
                    1,
                    "https://images.pexels.com/photos/8448165/pexels-photo-8448165.jpeg?_gl=1*7zun64*_ga*MTMwMTQ0MjI5NC4xNzc4NDI0Mjg0*_ga_8JE65Q40S6*czE3Nzg0MjQyODMkbzEkZzEkdDE3Nzg0MjQ5MDkkajI3JGwwJGgw",
                    false
                ),
                Food(
                    3,
                    "Hamburger",
                    description = "An example text...",
                    1,
                    "https://images.pexels.com/photos/1639562/pexels-photo-1639562.jpeg?_gl=1*1xlbe2w*_ga*MTMwMTQ0MjI5NC4xNzc4NDI0Mjg0*_ga_8JE65Q40S6*czE3Nzg0MjQyODMkbzEkZzEkdDE3Nzg0MjQzNTQkajUxJGwwJGgw",
                    false
                )
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
                foods = updatedFoods.sortedByDescending { it.numberOfLikes }
            )
        }

    }
}