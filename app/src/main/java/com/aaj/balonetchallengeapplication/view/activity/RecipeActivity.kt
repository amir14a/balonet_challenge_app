package com.aaj.balonetchallengeapplication.view.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.aaj.balonetchallengeapplication.R
import com.aaj.balonetchallengeapplication.databinding.ActivityRecipeBinding
import com.aaj.balonetchallengeapplication.databinding.IngredientItemBinding
import com.aaj.balonetchallengeapplication.databinding.RecipeStepItemBinding
import com.aaj.balonetchallengeapplication.model.RecipeIngredientsModel
import com.aaj.balonetchallengeapplication.model.RecipeModel
import com.aaj.balonetchallengeapplication.util.StaticParameters
import com.aaj.balonetchallengeapplication.view.adapter.GlobalAdapter
import com.aaj.balonetchallengeapplication.viewmodel.RecipeActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeActivity : BaseActivity<ActivityRecipeBinding, RecipeActivityViewModel>(
    R.layout.activity_recipe,
    RecipeActivityViewModel::class.java
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        viewModel.recipe.value =
            intent?.getSerializableExtra("Recipe") as RecipeModel

        if (!viewModel.recipe.value?.cookingStepsEnglish.isNullOrEmpty() && StaticParameters.isEnglish)
            binding.stepsRecycler.adapter = GlobalAdapter<String, RecipeStepItemBinding>(
                R.layout.recipe_step_item,
                viewModel.recipe.value!!.cookingStepsEnglish,
                moreBindings = { pos, binding -> binding.position = pos }
            )
        if (!viewModel.recipe.value?.cookingSteps.isNullOrEmpty() && !StaticParameters.isEnglish)
            binding.stepsRecycler.adapter = GlobalAdapter<String, RecipeStepItemBinding>(
                R.layout.recipe_step_item,
                viewModel.recipe.value!!.cookingSteps,
                moreBindings = { pos, binding -> binding.position = pos }
            )

        viewModel.fetchIngredients()
        viewModel.recipeIngredients.observe(this) {
            if (!it.isNullOrEmpty()) {
                binding.ingredientsRecycler.adapter =
                    GlobalAdapter<RecipeIngredientsModel, IngredientItemBinding>(
                        R.layout.ingredient_item,
                        it
                    )
            }
        }

    }
}