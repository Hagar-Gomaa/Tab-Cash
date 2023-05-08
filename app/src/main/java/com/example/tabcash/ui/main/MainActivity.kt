package com.example.tabcash.ui.main

import android.content.res.ColorStateList
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.tabcash.R
import com.example.tabcash.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        //setContentView(binding.root)
// Set up ActionBar
//        setSupportActionBar(findViewById(R.id.toolbar))
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_host) as NavHostFragment
        val navController = navHostFragment.navController
        setupNavigation(navController)

        binding.fab.imageTintList=(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.white)));
    }


    private fun setupNavigation(navController: NavController) {
        // Set up ActionBar with NavController
//        NavigationUI.setupActionBarWithNavController(this, navController)
    binding.bottomNavigationView.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment_host)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}


//override fun onResume() {
//    super.onResume()
//    setupNavigation()
//}
//
//private fun setupNavigation() {
//    val navController = findNavController(R.id.fragment_host)
//    NavigationUI.setupActionBarWithNavController(this, navController)
//    binding.bottomNav.setupWithNavController(navController)
//}

