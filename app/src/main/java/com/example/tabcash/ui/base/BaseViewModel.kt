package com.example.tabcash.ui.base

import androidx.lifecycle.ViewModel
import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
open class BaseViewModel<N: BaseNavigator> : ViewModel(){
    var navigator:N?=null
    var errorMessage:String?=null
}