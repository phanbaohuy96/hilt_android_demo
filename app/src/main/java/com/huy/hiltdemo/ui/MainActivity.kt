package com.huy.hiltdemo.ui

import androidx.databinding.ViewDataBinding
import com.huy.hiltdemo.R
import com.huy.hiltdemo.base.BaseActivity
import com.huy.hiltdemo.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ViewDataBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_base

    override val setViewModel: BaseViewModel?
        get() = null

    override fun setDataBinding() = false

    override fun initView() {
        preferencesHelper.printValue()
        addFragment(MainFragment())
    }

    override fun detachView() {}
}