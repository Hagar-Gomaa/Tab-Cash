package com.example.tabcash.ui.main.home

import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import com.example.tabcash.repositoryContract.Repository
import com.example.tabcash.ui.base.BaseNavigator
import com.example.tabcash.ui.base.BaseViewModel
import com.example.tabcash.ui.login.LoginNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val repository: Repository) :
    BaseViewModel<BaseNavigator>(){


}