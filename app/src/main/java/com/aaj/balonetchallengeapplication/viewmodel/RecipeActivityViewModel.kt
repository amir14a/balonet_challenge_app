package com.aaj.balonetchallengeapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aaj.balonetchallengeapplication.database.AppDatabaseDao
import com.aaj.balonetchallengeapplication.model.RecipeIngredientsModel
import com.aaj.balonetchallengeapplication.model.RecipeModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RecipeActivityViewModel @Inject constructor(application: Application) :
    AndroidViewModel(application) {

    @Inject
    lateinit var database: AppDatabaseDao
    val recipe by lazy { MutableLiveData<RecipeModel>() }
    val recipeIngredients by lazy { MutableLiveData<List<RecipeIngredientsModel>>() }

    fun fetchIngredients() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = database.getRecipeIngredients(recipe.value!!.id)
            for (item in data) {
                item.ingredient = database.getIngredient(item.ingredientId)
            }
            withContext(Dispatchers.Main) {
                recipeIngredients.value = data
            }
        }
    }
}