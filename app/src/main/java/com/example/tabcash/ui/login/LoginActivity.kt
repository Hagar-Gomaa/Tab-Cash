package com.example.tabcash.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.tabcash.R
import com.example.tabcash.databinding.ActivityLoginBinding
import com.example.tabcash.ui.base.BaseActivity
import com.example.tabcash.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(),LoginNavigator {
     val viewModel :LoginViewModel by viewModels()
    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       viewBinding.vm = viewModel
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