package com.aaj.balonetchallengeapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aaj.balonetchallengeapplication.model.CategoryModel
import com.aaj.balonetchallengeapplication.model.IngredientModel
import com.aaj.balonetchallengeapplication.model.RecipeIngredientsModel
import com.aaj.balonetchallengeapplication.model.RecipeModel

@Database(
    entities = [CategoryModel::class, IngredientModel::class, RecipeModel::class, RecipeIngredientsModel::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getAppDatabase(): AppDatabaseDao
}