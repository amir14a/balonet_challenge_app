package com.aaj.balonetchallengeapplication.viewmodel

import android.app.Application
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(application: Application) :
    AndroidViewModel(application) {

    @Inject
    lateinit var sp: SharedPreferences
    fun saveNightMode(isNightMode: Boolean) {
        sp.edit().putBoolean("isNightMode", isNightMode).apply()
    }

    fun saveIsEnglish(isEnglish: Boolean) {
        sp.edit().putBoolean("isEnglish", isEnglish).apply()
    }

    fun saveTextSize(textSize: Float) {
        sp.edit().putFloat("appDefaultTextSize", textSize).apply()
    }
}