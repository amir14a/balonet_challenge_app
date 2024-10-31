package com.aaj.balonetchallengeapplication.view.fragment

import android.os.Bundle
import android.view.View
import com.aaj.balonetchallengeapplication.R
import com.aaj.balonetchallengeapplication.databinding.FragmentProfileBinding
import com.aaj.balonetchallengeapplication.viewmodel.ProfileFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileFragmentViewModel>(
    R.layout.fragment_profile,
    ProfileFragmentViewModel::class.java
) {
    companion object {
        fun newInstance() = ProfileFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
