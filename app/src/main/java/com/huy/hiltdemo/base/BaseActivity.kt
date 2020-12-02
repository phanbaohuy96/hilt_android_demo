package com.huy.hiltdemo.base

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.huy.hiltdemo.R
import com.huy.hiltdemo.data.PreferencesHelper
import javax.inject.Inject

abstract class BaseActivity<DB : ViewDataBinding> : AppCompatActivity(){

    @Inject
    lateinit var preferencesHelper: PreferencesHelper

    val binding by lazy {
        DataBindingUtil.setContentView(this, layoutId) as DB
    }

    abstract val layoutId: Int

    abstract val setViewModel: BaseViewModel?

    /**
     * Return is use data binding on activity and set viewmodel
     */
    abstract fun setDataBinding(): Boolean

    abstract fun initView()

    abstract fun detachView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (setDataBinding()) {
            binding.lifecycleOwner = this
            binding.executePendingBindings()
        } else {
            setContentView(layoutId)
        }
        initView()
    }

    fun addFragment(fragment: Fragment, addBackStack: String? = null) {
        supportFragmentManager.commit {
            addToBackStack(addBackStack)
            add(R.id.layout_container, fragment)
        }
    }

    fun addFragmentToStack(fragment: BaseFragment<ViewDataBinding>) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right
            )
            .add(R.id.layout_container, fragment)
            .addToBackStack(null)
            .commit()
        supportFragmentManager.executePendingTransactions()
    }

    override fun onDestroy() {
        super.onDestroy()
        detachView()
    }
    override fun applyOverrideConfiguration(overrideConfiguration: Configuration?) {
        if (overrideConfiguration != null) {
            val uiMode = overrideConfiguration.uiMode
            overrideConfiguration.setTo(baseContext.resources.configuration)
            overrideConfiguration.uiMode = uiMode
        }
        super.applyOverrideConfiguration(overrideConfiguration)
    }
}