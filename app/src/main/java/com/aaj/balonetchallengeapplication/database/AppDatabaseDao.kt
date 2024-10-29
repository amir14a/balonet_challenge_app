package com.aaj.balonetchallengeapplication.database

import androidx.room.Dao
import androidx.room.Query
import com.aaj.balonetchallengeapplication.model.CategoryModel

@Dao
interface AppDatabaseDao {
    @Query("SELECT * FROM Categories")
    suspend fun getAllCategories(): List<CategoryModel>
}