package com.example.tabcash.ui.base

import OnDialogClickListener

interface BaseNavigator {
    fun showLoading(message:String)
    fun hideLoading()
    fun showMessage(message:String,
                    posActionTitle:String?=null,
                    posAction:OnDialogClickListener?=null,
                    negActionTitle:String?=null,
                    negAction:OnDialogClickListener?=null, )
}
