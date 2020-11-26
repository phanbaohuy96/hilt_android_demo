package com.huy.hiltdemo.ui

import com.huy.hiltdemo.data.PreferencesHelper
import javax.inject.Inject

class MainAdapter @Inject constructor(
    val  preferencesHelper: PreferencesHelper
)