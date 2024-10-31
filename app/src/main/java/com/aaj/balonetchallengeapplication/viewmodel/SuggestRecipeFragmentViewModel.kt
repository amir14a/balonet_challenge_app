package com.aaj.balonetchallengeapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SuggestRecipeFragmentViewModel @Inject constructor(application: Application) :
    AndroidViewModel(application) {
}