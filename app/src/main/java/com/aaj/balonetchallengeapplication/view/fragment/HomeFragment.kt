package com.aaj.balonetchallengeapplication.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.aaj.balonetchallengeapplication.R
import com.aaj.balonetchallengeapplication.databinding.FragmentHomeBinding
import com.aaj.balonetchallengeapplication.view.activity.CategoryActivity
import com.aaj.balonetchallengeapplication.view.adapter.CategoriesAdapter
import com.aaj.balonetchallengeapplication.viewmodel.HomeFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeFragmentViewModel>(
    R.layout.fragment_home,
    HomeFragmentViewModel::class.java
) {
    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchCategories()
        viewModel.categories.observe(viewLifecycleOwner) {
            if (!it.isNullOrEmpty()) {
                val adapter = CategoriesAdapter(it) { category ->
                    startActivity(
                        Intent(context, CategoryActivity::class.java).putExtra(
                            "Category", category
                        )
                    )
                }
                binding.categoriesRecyclerView.adapter = adapter
            }
        }
    }
}
