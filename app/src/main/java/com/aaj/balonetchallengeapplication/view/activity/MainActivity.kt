package com.aaj.balonetchallengeapplication.view.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.aaj.balonetchallengeapplication.R
import com.aaj.balonetchallengeapplication.databinding.ActivityMainBinding
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
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START))
            binding.drawerLayout.closeDrawers()
        else
            super.onBackPressed()
    }
}