package com.aaj.balonetchallengeapplication.view.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.aaj.balonetchallengeapplication.R
import com.aaj.balonetchallengeapplication.databinding.ActivityMainBinding
import com.aaj.balonetchallengeapplication.util.StaticParameters
import com.aaj.balonetchallengeapplication.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>(
    R.layout.activity_main,
    MainActivityViewModel::class.java
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding.menuButton.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        binding.mainNavHost.post {
            binding.bottomNavigationView.setupWithNavController(binding.mainNavHost.findNavController())
        }

        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.clearCache -> {
                }
            }
            return@setNavigationItemSelectedListener true
        }
        val nightModeSwitch = binding.navView.menu.findItem(R.id.nightMode).actionView
            ?.findViewById<SwitchCompat>(R.id.nightModeSwitch)
        nightModeSwitch?.isChecked = StaticParameters.isNightMode
        nightModeSwitch?.setOnCheckedChangeListener { _, value ->
            StaticParameters.isNightMode = value
            viewModel.saveNightMode(value)
            if (StaticParameters.isNightMode)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            else
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START))
            binding.drawerLayout.closeDrawers()
        else
            super.onBackPressed()
    }
}