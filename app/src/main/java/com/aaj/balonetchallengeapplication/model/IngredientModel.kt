package com.aaj.balonetchallengeapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Ingredients")
data class IngredientModel(
    @PrimaryKey val id: Int,
    val name: String,
    val unit: String,
)
