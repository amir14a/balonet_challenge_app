package com.aaj.balonetchallengeapplication.view.fragment

import android.os.Bundle
import android.view.View
import com.aaj.balonetchallengeapplication.R
import com.aaj.balonetchallengeapplication.databinding.FragmentHomeBinding
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
    }
}
