package com.example.hw_3ibrakhimgroup.ui.activity
import com.example.hw_3ibrakhimgroup.utils.PreferenceHelper

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hw_3ibrakhimgroup.R
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import com.example.hw_3ibrakhimgroup.App
import com.example.hw_3ibrakhimgroup.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        initialize()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initialize() {

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_graph) as? NavHostFragment
        val navController = navHostFragment?.navController ?: return

        Log.d("ololo", "is first visit = " +  App.sharedPreferences.isFirstVisit)
        if (! App.sharedPreferences.isFirstVisit) {
            val navOptions = NavOptions.Builder().setPopUpTo(R.id.onboardFragment,true).build()
            navController.navigate(R.id.mainFragment, null, navOptions)
        }
    }
}