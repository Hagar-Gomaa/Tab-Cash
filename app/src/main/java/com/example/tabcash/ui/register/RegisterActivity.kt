package com.example.tabcash.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.tabcash.R
import com.example.tabcash.databinding.ActivityRegisterBinding
import com.example.tabcash.ui.base.BaseActivity
import com.example.tabcash.ui.main.MainActivity
import com.example.tabcash.ui.register.RegisterNavigator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class RegisterActivity : BaseActivity<ActivityRegisterBinding, RegisterViewModel>(),RegisterNavigator {
    val viewModel :RegisterViewModel by viewModels()
    override fun getLayoutId(): Int {
        return R.layout.activity_register
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.vm = viewModel
        viewModel.navigator=this
    }

    override fun goToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)

    }

    override fun goToHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}