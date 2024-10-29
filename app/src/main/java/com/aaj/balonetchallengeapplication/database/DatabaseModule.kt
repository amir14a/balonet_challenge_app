package com.aaj.balonetchallengeapplication.database

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(application: Application): AppDatabaseDao {
        return Room.databaseBuilder(application, AppDatabase::class.java, "ZardChoobehDb.db")
            .createFromAsset("DefaultRecipes.sqlite")
            .build()
            .getAppDatabase()
    }
}