package com.example.hw_3ibrakhimgroup.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper {
    private lateinit var sharedPreferences: SharedPreferences
    private val IS_FIRST_VISIT="IS_FIRST_VISIT"
    fun unit(context: Context){
        sharedPreferences=context.getSharedPreferences("data", Context.MODE_PRIVATE)
    }
    var isFirstVisit: Boolean
        get()=sharedPreferences.getBoolean(IS_FIRST_VISIT,true)
        set(value) = sharedPreferences.edit().putBoolean(IS_FIRST_VISIT,value).apply()
}