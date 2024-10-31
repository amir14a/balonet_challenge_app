package com.aaj.balonetchallengeapplication.view.fragment

import android.os.Bundle
import android.view.View
import com.aaj.balonetchallengeapplication.R
import com.aaj.balonetchallengeapplication.databinding.FragmentSuggestRecipeBinding
import com.aaj.balonetchallengeapplication.viewmodel.SuggestRecipeFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SuggestRecipeFragment :
    BaseFragment<FragmentSuggestRecipeBinding, SuggestRecipeFragmentViewModel>(
        R.layout.fragment_suggest_recipe,
        SuggestRecipeFragmentViewModel::class.java
    ) {
    companion object {
        fun newInstance() = SuggestRecipeFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
