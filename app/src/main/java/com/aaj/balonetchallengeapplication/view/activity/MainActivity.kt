package com.aaj.balonetchallengeapplication.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.aaj.balonetchallengeapplication.R
import com.aaj.balonetchallengeapplication.databinding.ActivityMainBinding
import com.aaj.balonetchallengeapplication.view.adapter.CategoriesAdapter
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
        viewModel.fetchCategories()
        viewModel.categories.observe(this) {
            if (!it.isNullOrEmpty()) {
                val adapter = CategoriesAdapter(it) { category ->
                    startActivity(
                        Intent(this, CategoryActivity::class.java).putExtra(
                            "Category", category
                        )
                    )
                }
                binding.categoriesRecyclerView.layoutManager = LinearLayoutManager(this)
                binding.categoriesRecyclerView.adapter = adapter
            }
        }

    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START))
            binding.drawerLayout.closeDrawers()
        else
            super.onBackPressed()
    }
}