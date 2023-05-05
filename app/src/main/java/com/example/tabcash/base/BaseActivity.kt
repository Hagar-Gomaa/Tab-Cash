package com.example.tabcash.base

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import javax.inject.Inject

abstract class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel<*>>():
    AppCompatActivity(), BaseNavigator {

    lateinit var viewBinding: VB
    @Inject
     protected lateinit var viewModel: VM
    abstract fun getLayoutId(): Int
    abstract fun generateViewModel(): VM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(
            this, getLayoutId()
        )
        viewModel = generateViewModel()
    }

    var progressDialog: ProgressDialog? = null
    override fun showLoading(message: String) {
        progressDialog = ProgressDialog(this);
        progressDialog?.setMessage(message);
        progressDialog?.show()
    }

    override fun hideLoading() {
        progressDialog?.dismiss()
        progressDialog = null;
    }
}