package com.aaj.balonetchallengeapplication.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.aaj.balonetchallengeapplication.R
import com.aaj.balonetchallengeapplication.databinding.FragmentSearchBinding
import com.aaj.balonetchallengeapplication.view.activity.RecipeActivity
import com.aaj.balonetchallengeapplication.view.adapter.RecipesAdapter
import com.aaj.balonetchallengeapplication.viewmodel.SearchFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding, SearchFragmentViewModel>(
    R.layout.fragment_search,
    SearchFragmentViewModel::class.java
) {
    companion object {
        fun newInstance() = SearchFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.searchText.observe(viewLifecycleOwner) {
            if (!it.isNullOrEmpty()) {
                viewModel.fetchRecipes()
            } else {
                binding.recipesRecyclerView.adapter = null
            }
        }
        viewModel.recipes.observe(viewLifecycleOwner) {
            if (!viewModel.searchText.value.isNullOrEmpty()) {
                val adapter = RecipesAdapter(it) { recipe ->
                    startActivity(
                        Intent(context, RecipeActivity::class.java).putExtra(
                            "Recipe", recipe
                        )
                    )
                }
                binding.recipesRecyclerView.adapter = adapter
            }
        }

    }
}
