package com.aaj.balonetchallengeapplication.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider

open class BaseFragment<T : ViewDataBinding, T2 : AndroidViewModel>(
    @LayoutRes
    private val layout: Int,
    private val clazz: Class<T2>,
) : Fragment() {
    lateinit var binding: T
    lateinit var viewModel: T2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[clazz]
        binding = DataBindingUtil.inflate(inflater, layout, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.setVariable(BR.viewModel, viewModel)
        binding.setVariable(BR.view, this)
        binding.executePendingBindings()
        return binding.root
    }
}