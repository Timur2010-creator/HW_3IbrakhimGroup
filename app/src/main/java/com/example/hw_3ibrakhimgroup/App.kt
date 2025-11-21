package com.example.hw_3ibrakhimgroup

import android.app.Application
import com.example.hw_3ibrakhimgroup.utils.PreferenceHelper

class App: Application() {
    companion object{
        val sharedPreferences= PreferenceHelper()
    }

    override fun onCreate() {
        super.onCreate()
        sharedPreferences.unit(this)
    }
}