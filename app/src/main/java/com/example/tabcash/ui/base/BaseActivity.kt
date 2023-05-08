package com.example.tabcash.ui.base

import OnDialogClickListener
import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import javax.inject.Inject

abstract class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel<*>>():
    AppCompatActivity(), BaseNavigator {

    lateinit var viewBinding: VB
//   lateinit var viewModel: VM
    abstract fun getLayoutId(): Int
//    abstract fun generateViewModel(): VM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(
            this, getLayoutId()
        )

    }

    var progressDialog: ProgressDialog? = null
    var alertDialog: AlertDialog? = null

    override fun showLoading(message: String) {
        progressDialog = ProgressDialog(this);
        progressDialog?.setMessage(message);
        progressDialog?.show()
    }

    override fun hideLoading() {
        alertDialog?.dismiss()
        progressDialog?.dismiss()
        progressDialog = null;
    }
    override fun showMessage(message:String,
                             posActionTitle:String?,
                             posAction:OnDialogClickListener?,
                             negActionTitle:String?,
                             negAction:OnDialogClickListener?) {
        val builder =
            AlertDialog.Builder(this)
                .setMessage(message);
        if(posActionTitle!=null){
            builder.setPositiveButton(posActionTitle) {
                    dialogInterface, i ->
                dialogInterface.dismiss()
                posAction?.onClick()
            }
        }
        if(negActionTitle!=null){
            builder.setNegativeButton(negActionTitle) {
                    dialogInterface, i ->
                dialogInterface.dismiss()
                negAction?.onClick()
            }
        }
        alertDialog =  builder.show()
    }

}
