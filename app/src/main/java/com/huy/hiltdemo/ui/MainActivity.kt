package com.huy.hiltdemo.ui

import androidx.activity.viewModels
import androidx.databinding.ViewDataBinding
import com.huy.hiltdemo.R
import com.huy.hiltdemo.base.BaseActivity
import com.huy.hiltdemo.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ViewDataBinding>() {

    private val viewModel: MainViewModel by viewModels()

    override val layoutId: Int
        get() = R.layout.activity_base

    override val setViewModel: BaseViewModel?
        get() = viewModel

    override fun setDataBinding() = false

    override fun initView() {
        addFragment(MainFragment())
    }

    override fun detachView() {}
}