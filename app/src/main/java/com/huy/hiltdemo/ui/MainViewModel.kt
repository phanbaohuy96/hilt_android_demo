package com.huy.hiltdemo.ui

import androidx.hilt.lifecycle.ViewModelInject
import com.huy.hiltdemo.base.BaseViewModel

class MainViewModel @ViewModelInject internal constructor() : BaseViewModel() {
    var count = 1
}