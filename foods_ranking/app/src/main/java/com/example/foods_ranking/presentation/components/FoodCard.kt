package com.example.foods_ranking.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foods_ranking.domain.model.Food

@Composable
fun FoodCard(
    food: Food,
    liked: Boolean,
    onLikeClicked: () -> Unit
) {
    val buttonText = if (liked) "Unlike" else "Like"

    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(24.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = food.name,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = "${food.numberOfLikes} likes"
                )
            }
            Button(
                onClick = onLikeClicked
            ) {
                Text(buttonText)
            }
        }
    }
}