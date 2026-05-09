package com.example.foods_ranking.presentation.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.foods_ranking.presentation.components.FoodCard
import com.example.foods_ranking.presentation.viewmodel.FoodViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Modifier.FoodScreen(
    viewModel: FoodViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    LazyColumn(
        modifier = this
    ) {
        items(uiState.foods) { food ->
            FoodCard(food)
        }
    }
}