package com.aaj.balonetchallengeapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Categories")
data class CategoryModel(
    @PrimaryKey val id: Int,
    val title: String,
    val titleEnglish: String,
    val imageUrl: String?,
    val imageBlurHash: String?,
) : Serializable
