package com.aaj.balonetchallengeapplication.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "RecipeIngredients",
    foreignKeys = [
        ForeignKey(
            entity = IngredientModel::class,
            parentColumns = ["id"],
            childColumns = ["ingredientId"]
        ),
        ForeignKey(
            entity = RecipeModel::class,
            parentColumns = ["id"],
            childColumns = ["recipeId"]
        ),
    ],
)
data class RecipeIngredientsModel(
    @PrimaryKey val id: Int,
    val recipeId: Int,
    val ingredientId: Int,
    val amount: Double,
)
