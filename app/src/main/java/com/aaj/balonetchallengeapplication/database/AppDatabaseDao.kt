package com.aaj.balonetchallengeapplication.database

import androidx.room.Dao
import androidx.room.Query
import com.aaj.balonetchallengeapplication.model.CategoryModel
import com.aaj.balonetchallengeapplication.model.IngredientModel
import com.aaj.balonetchallengeapplication.model.RecipeIngredientsModel
import com.aaj.balonetchallengeapplication.model.RecipeModel

@Dao
interface AppDatabaseDao {
    @Query("SELECT * FROM Categories")
    suspend fun getAllCategories(): List<CategoryModel>

    @Query("SELECT * FROM Recipes WHERE categoryId=:categoryId")
    suspend fun getRecipesForCategory(categoryId: Int): List<RecipeModel>

    @Query("SELECT * FROM RecipeIngredients WHERE recipeId=:recipeId")
    suspend fun getRecipeIngredients(recipeId: Int): List<RecipeIngredientsModel>

    @Query("SELECT * FROM Ingredients WHERE id=:ingredientId")
    suspend fun getIngredient(ingredientId: Int): IngredientModel
}