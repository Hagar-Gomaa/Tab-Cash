package com.example.tabcash.ui.main

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.tabcash.R
import com.example.tabcash.databinding.ActivityMainBinding
import com.example.tabcash.ui.base.BaseActivity
import com.example.tabcash.ui.base.BaseViewModel
import com.example.tabcash.ui.main.home.TransactionFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, BaseViewModel<*>>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    val transactionFragment: TransactionFragment = TransactionFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setSupportActionBar(findViewById(R.id.toolbar))
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_host) as NavHostFragment
        val navController = navHostFragment.navController
        setupNavigation(navController)

        viewBinding.fab.imageTintList =
            (ColorStateList.valueOf(ContextCompat.getColor(this, R.color.white)));
        viewBinding.apply {
            fab.setOnClickListener {

                when (navController.currentDestination?.id) {
                    R.id.homeFragment -> {
                        navigate(navController, R.id.action_homeFragment_to_transactionFragment)
                    }

                    R.id.cardsFragment -> {
                        navigate(navController, R.id.action_cardsFragment_to_transactionFragment)
                    }

                    R.id.historyFragment -> {
                        navigate(navController, R.id.action_historyFragment_to_transactionFragment)
                    }

                    R.id.kidsFragment -> {
                        navigate(navController, R.id.action_kidsFragment_to_transactionFragment)
                    }

                    R.id.cashInFragment -> {
                        navigate(navController, R.id.action_cashInFragment_to_transactionFragment)
                    }

                    R.id.cashOutFragment -> {
                        navigate(navController, R.id.action_cashOutFragment_to_transactionFragment)
                    }

                    R.id.donationsFragment -> {
                        navigate(
                            navController,
                            R.id.action_donationsFragment_to_transactionFragment
                        )
                    }
                }
            }
        }
    }

    private fun setupNavigation(navController: NavController) {
        viewBinding.bottomNavigationView.setupWithNavController(navController)
       NavigationUI.setupActionBarWithNavController(this, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment_host)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}

private fun navigate(navController: NavController, action: Int) {
    navController.navigate(action)
}

