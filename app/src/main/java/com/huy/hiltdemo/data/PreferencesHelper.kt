package com.huy.hiltdemo.data

import android.content.Context
import android.util.Log

class PreferencesHelper(val context: Context) {
    var value = "ABC"
    fun printValue() {
        Log.d("huylogcat", "================> $value")
        value += value
    }
}