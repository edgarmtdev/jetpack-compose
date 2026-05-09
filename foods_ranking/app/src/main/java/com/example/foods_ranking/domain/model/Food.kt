package com.example.foods_ranking.domain.model

data class Food(
    val id: Int,
    val name: String,
    val numberOfLikes: Int,
    val imageUrl: String,
    val liked: Boolean = false
)