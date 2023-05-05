package com.example.tabcash.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.tabcash.R
import com.example.tabcash.base.BaseActivity
import com.example.tabcash.databinding.ActivityLoginBinding
import com.example.tabcash.ui.main.MainActivity
import com.example.tabcash.ui.register.RegisterActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(),LoginNavigator {

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun generateViewModel(): LoginViewModel {
        return ViewModelProvider(this).get(LoginViewModel::class.java)
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