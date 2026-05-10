package com.example.foods_ranking.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
                    .fillMaxWidth()
                    .height(240.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 16.dp,
                            topEnd = 16.dp
                        )
                    ),
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
                }
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .clickable(
                            onClick = onLikeClicked
                        )
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector =
                            if (liked)
                                Icons.Filled.Favorite
                            else
                                Icons.Outlined.FavoriteBorder,
                        contentDescription = "Like",
                        modifier = Modifier.size(24.dp),
                        tint =
                            if (liked)
                                Color.Red
                            else
                                MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "${food.numberOfLikes}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}