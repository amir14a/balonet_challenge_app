package com.aaj.balonetchallengeapplication.view.activity

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider

open class BaseActivity<T : ViewDataBinding, T2 : AndroidViewModel>(
    @LayoutRes
    private val resId: Int,
    private val clazz: Class<T2>,
) : AppCompatActivity() {
    lateinit var binding: T
    lateinit var viewModel: T2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.layoutDirection = View.LAYOUT_DIRECTION_RTL

        viewModel = ViewModelProvider(this)[clazz]
        binding = DataBindingUtil.setContentView(this, resId)
        binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel, viewModel)
        binding.setVariable(BR.view, this)
        binding.executePendingBindings()
    }
}