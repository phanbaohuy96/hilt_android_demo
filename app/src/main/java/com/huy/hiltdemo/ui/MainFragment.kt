package com.huy.hiltdemo.ui

import android.util.Log
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.viewModels
import com.huy.hiltdemo.R
import com.huy.hiltdemo.base.BaseFragment
import com.huy.hiltdemo.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : BaseFragment<ViewDataBinding>() {

    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var mainAdapter : MainAdapter

    override val layoutId: Int
        get() = R.layout.activity_main

    override val setViewModel: BaseViewModel?
        get() = viewModel

    override fun setDataBinding() = false

    override fun initView() {
        Log.d("huylogcat", "MainFragment initView ${viewModel.count}")

        mainAdapter.preferencesHelper.printValue()
    }
}