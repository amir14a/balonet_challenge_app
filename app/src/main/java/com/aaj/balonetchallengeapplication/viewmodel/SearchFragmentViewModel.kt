package com.aaj.balonetchallengeapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aaj.balonetchallengeapplication.database.AppDatabaseDao
import com.aaj.balonetchallengeapplication.model.RecipeModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SearchFragmentViewModel @Inject constructor(application: Application) :
    AndroidViewModel(application) {
    @Inject
    lateinit var database: AppDatabaseDao
    val searchText: MutableLiveData<String> by lazy { MutableLiveData() }
    val isLoading: MutableLiveData<Boolean> by lazy { MutableLiveData(false) }
    val recipes by lazy { MutableLiveData<List<RecipeModel>>() }

    fun fetchRecipes() {
        isLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            val data = database.searchForRecipes(searchText.value ?: "")
            for (item in data) item.category = database.getCategoryById(item.categoryId)
            withContext(Dispatchers.Main) {
                recipes.value = data
                isLoading.value = false
            }
        }
    }
}