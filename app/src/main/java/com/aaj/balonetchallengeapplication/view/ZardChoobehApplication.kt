package com.aaj.balonetchallengeapplication.view

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.PreferenceManager
import com.aaj.balonetchallengeapplication.util.StaticParameters
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class ZardChoobehApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        StaticParameters.isNightMode = sharedPreferences.getBoolean("isNightMode", false)
        StaticParameters.appDefaultTextSize = sharedPreferences.getFloat("appDefaultTextSize", 12f)
        StaticParameters.isEnglish = sharedPreferences.getBoolean("isEnglish", false)
        if (StaticParameters.isNightMode)
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        else
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}