package com.example.foods_ranking.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodTopBar(
    onLogout: () -> Unit
) {
    TopAppBar(
        title = {
            Text("🍔 Food Rank")
        },
        actions = {
            IconButton(
                onClick = onLogout
            ) {
                Icon(
                    imageVector =
                        Icons.AutoMirrored.Filled.Logout,
                    contentDescription = "Logout"
                )
            }
        }
    )
}