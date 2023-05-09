package com.example.tabcash.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.tabcash.R
import com.example.tabcash.databinding.ActivityRegisterBinding
import com.example.tabcash.ui.base.BaseActivity
import com.example.tabcash.ui.main.MainActivity
import com.example.tabcash.ui.main.history.HistoryFragment
import com.example.tabcash.ui.register.RegisterNavigator
import com.example.tabcash.utils.MySharedPreferences
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class RegisterActivity : BaseActivity<ActivityRegisterBinding, RegisterViewModel>(),
    RegisterNavigator {
    private val viewModel: RegisterViewModel by viewModels()
    private val mySharedPreferences : MySharedPreferences by lazy {
        MySharedPreferences(this)
    }
    lateinit var token:String
    override fun getLayoutId(): Int {
        return R.layout.activity_register
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.vm = viewModel
        viewModel.navigator = this
      viewModel.token?.let { mySharedPreferences.saveToken(it) }
    }

    private fun parseToFragmentByBundel(){
        val bundle = Bundle()
        bundle.putString("TOKEN_KEY", token)

        val fragment = HistoryFragment()
        fragment.arguments = bundle
    }

    override fun onPause() {
        super.onPause()
        setTokenValue()
        parseToFragmentByBundel()

    }

    private fun setTokenValue() {
        viewModel.token?.let { mySharedPreferences.saveToken(it) }
        token = mySharedPreferences.getToken()!!
        Log.e("token", token)
    }

    override fun goToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
    intent.putExtra("token",token)
        startActivity(intent)
    }


    override fun goToHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}