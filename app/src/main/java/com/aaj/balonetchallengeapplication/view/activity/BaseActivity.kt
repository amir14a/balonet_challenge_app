package com.aaj.balonetchallengeapplication.view.activity

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import com.aaj.balonetchallengeapplication.util.StaticParameters
import java.util.Locale

open class BaseActivity<T : ViewDataBinding, T2 : AndroidViewModel>(
    @LayoutRes
    private val resId: Int,
    private val clazz: Class<T2>,
) : AppCompatActivity() {
    lateinit var binding: T
    lateinit var viewModel: T2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[clazz]
        binding = DataBindingUtil.setContentView(this, resId)
        binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel, viewModel)
        binding.setVariable(BR.view, this)
        binding.executePendingBindings()
    }
    fun changeLanguageTo(localeCode: String): Context {
        val locale = Locale(localeCode)
        Locale.setDefault(locale)
        val configs = resources.configuration
        configs.setLocale(locale)
        configs.setLayoutDirection(locale)
        return createConfigurationContext(configs)
    }

    override fun attachBaseContext(newBase: Context) {
        val locale = if (StaticParameters.isEnglish) Locale("en") else Locale("fa")
        val config = Configuration(newBase.resources.configuration)
        config.setLocale(locale)
        val context = newBase.createConfigurationContext(config)
        super.attachBaseContext(context)
    }
}