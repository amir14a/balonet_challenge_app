package com.aaj.balonetchallengeapplication.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Recipes",
    foreignKeys = [
        ForeignKey(
            entity = CategoryModel::class,
            childColumns = arrayOf("categoryId"),
            parentColumns = arrayOf("id")
        ),
    ]
)
data class RecipeModel(
    @PrimaryKey val id: Int,
    val name: String,
    val categoryId: Int,
    val imageUrl: String?,
    val imageBlurHash: String?,
    val cookTimeMinutes: Int,
    val ingredients: List<IngredientModel>,
    val cookingSteps: List<String>,
    val personsCount: Int = 1,
    val likesCount: Int = 0,
    val commentsCount: Int = 0,
)
