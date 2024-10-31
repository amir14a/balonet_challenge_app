package com.aaj.balonetchallengeapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aaj.balonetchallengeapplication.database.AppDatabaseDao
import com.aaj.balonetchallengeapplication.model.CategoryModel
import com.aaj.balonetchallengeapplication.model.RecipeModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CategoryActivityViewModel @Inject constructor(application: Application) :
    AndroidViewModel(application) {

    @Inject
    lateinit var database: AppDatabaseDao
    val category by lazy { MutableLiveData<CategoryModel>() }
    val recipes by lazy { MutableLiveData<List<RecipeModel>>() }

    fun fetchRecipes() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = database.getRecipesForCategory(category.value!!.id)
            for (item in data) item.category = category.value
            withContext(Dispatchers.Main) {
                recipes.value = data
            }
        }
    }
}