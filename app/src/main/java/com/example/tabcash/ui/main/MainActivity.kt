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
import com.example.tabcash.ui.base.BaseActivity
import com.example.tabcash.ui.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, BaseViewModel<*>>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setSupportActionBar(findViewById(R.id.toolbar))
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_host) as NavHostFragment
        val navController = navHostFragment.navController
        setupNavigation(navController)

        viewBinding.fab.imageTintList =
            (ColorStateList.valueOf(ContextCompat.getColor(this, R.color.white)));
    }


    private fun setupNavigation(navController: NavController) {
//        NavigationUI.setupActionBarWithNavController(this, navController)
        viewBinding.bottomNavigationView.setupWithNavController(navController)

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

