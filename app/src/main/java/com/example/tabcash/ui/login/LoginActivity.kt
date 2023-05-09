package com.example.tabcash.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.tabcash.R
import com.example.tabcash.databinding.ActivityLoginBinding
import com.example.tabcash.ui.base.BaseActivity
import com.example.tabcash.ui.main.MainActivity
import com.example.tabcash.utils.MySharedPreferences
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(), LoginNavigator {
    private val viewModel: LoginViewModel by viewModels()

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }
    private val mySharedPreferences : MySharedPreferences by lazy {
        MySharedPreferences(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.vm = viewModel
        viewModel.navigator = this
        mySharedPreferences.saveRememberme(viewModel.Login_Activity_rememberMe.get()?:false)
      if (mySharedPreferences.getRememberme().toString()=="true")viewModel.Login_Activity_rememberMe.set(true)
    }

//    override fun onStart() {
//        super.onStart()
//        val intent = intent
//        val tokenGetten = intent.getStringExtra("token")
//        if (tokenGetten != null) viewModel.token = tokenGetten
//    }

    override fun goToRegister() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)

    }

    override fun goToHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}