package com.example.foods_ranking.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.foods_ranking.domain.model.Food

@Composable
fun FoodCard(
    modifier: Modifier,
    food: Food,
    liked: Boolean,
    onLikeClicked: () -> Unit,
) {
    val buttonText = if (liked) "Unlike" else "Like"

    Card(
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            AsyncImage(
                model = food.imageUrl,
                contentDescription = food.name,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
            Row(
               modifier = Modifier
                   .padding(20.dp)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = food.name,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = food.description,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "${food.numberOfLikes} likes",
                        style = MaterialTheme.typography.bodySmall
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
}