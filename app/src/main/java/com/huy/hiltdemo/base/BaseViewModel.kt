package com.huy.hiltdemo.base

import androidx.lifecycle.ViewModel
import com.huy.hiltdemo.data.PreferencesHelper
import javax.inject.Inject

abstract class BaseViewModel: ViewModel() {
    @Inject
    lateinit var preferencesHelper: PreferencesHelper
}