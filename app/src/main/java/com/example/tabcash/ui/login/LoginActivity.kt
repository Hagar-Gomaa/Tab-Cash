package com.example.tabcash.ui.login

import android.content.Intent
import android.database.DatabaseUtils
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.tabcash.R
import com.example.tabcash.ui.base.BaseActivity
import com.example.tabcash.databinding.ActivityLoginBinding
import com.example.tabcash.databinding.ActivityMainBinding
import com.example.tabcash.ui.main.MainActivity
import com.example.tabcash.ui.register.RegisterActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(),LoginNavigator {
     val viewModel :LoginViewModel by viewModels()
    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this, getLayoutId())
       binding.vm = viewModel
        viewModel.navigator=this
    }

    override fun goToRegister() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)

    }

    override fun goToHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        }
}