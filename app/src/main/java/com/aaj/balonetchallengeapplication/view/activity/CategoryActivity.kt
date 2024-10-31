package com.aaj.balonetchallengeapplication.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.recyclerview.widget.GridLayoutManager
import com.aaj.balonetchallengeapplication.R
import com.aaj.balonetchallengeapplication.databinding.ActivityCategoryBinding
import com.aaj.balonetchallengeapplication.model.CategoryModel
import com.aaj.balonetchallengeapplication.view.adapter.RecipesAdapter
import com.aaj.balonetchallengeapplication.viewmodel.CategoryActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryActivity : BaseActivity<ActivityCategoryBinding, CategoryActivityViewModel>(
    R.layout.activity_category,
    CategoryActivityViewModel::class.java
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        viewModel.category.value =
            intent?.getSerializableExtra("Category") as CategoryModel

        viewModel.fetchRecipes()
        viewModel.recipes.observe(this) {
            if (!it.isNullOrEmpty()) {
                val adapter = RecipesAdapter(it) { recipe ->
                    startActivity(
                        Intent(this, RecipeActivity::class.java).putExtra(
                            "Recipe", recipe
                        )
                    )
                }
                binding.categoriesRecyclerView.layoutManager = GridLayoutManager(this, 2)
                binding.categoriesRecyclerView.adapter = adapter
            }
        }
    }
}