package com.aaj.balonetchallengeapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aaj.balonetchallengeapplication.database.AppDatabaseDao
import com.aaj.balonetchallengeapplication.model.CategoryModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(application: Application) :
    AndroidViewModel(application) {
    @Inject
    lateinit var database: AppDatabaseDao
    val categories by lazy { MutableLiveData<List<CategoryModel>>() }
    fun fetchCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = database.getAllCategories()
            withContext(Dispatchers.Main) {
                categories.value = data
            }
        }
    }
}