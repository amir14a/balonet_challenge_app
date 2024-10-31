package com.aaj.balonetchallengeapplication.database

import androidx.room.Dao
import androidx.room.Query
import com.aaj.balonetchallengeapplication.model.CategoryModel
import com.aaj.balonetchallengeapplication.model.RecipeModel

@Dao
interface AppDatabaseDao {
    @Query("SELECT * FROM Categories")
    suspend fun getAllCategories(): List<CategoryModel>

    @Query("SELECT * FROM Recipes WHERE categoryId=:categoryId")
    suspend fun getRecipesForCategory(categoryId: Int): List<RecipeModel>
}