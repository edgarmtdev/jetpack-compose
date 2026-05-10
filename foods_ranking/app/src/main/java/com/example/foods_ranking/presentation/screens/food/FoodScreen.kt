package com.example.foods_ranking.presentation.screens.food

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foods_ranking.presentation.components.FoodCard
import com.example.foods_ranking.presentation.viewmodel.food.FoodViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FoodScreen(
    viewModel: FoodViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    LazyColumn(
    ) {
        items(
            uiState.foods,
            key = { it.id }
        ) { food ->
            FoodCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .animateItem(),
                food,
                liked = food.liked,
                onLikeClicked = {
                    viewModel.toggleLike(food.id)
                }
            )
        }
    }
}