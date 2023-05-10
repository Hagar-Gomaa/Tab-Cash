package com.example.tabcash.ui.history

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tabcash.model.LoginResponse
import com.example.tabcash.isValidEmail
import com.example.tabcash.model.HistoryResponse
import com.example.tabcash.repositoryContract.Repository
import com.example.tabcash.ui.base.BaseNavigator
import com.example.tabcash.ui.base.BaseViewModel
import com.example.tabcash.ui.login.LoginNavigator
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(val repository: Repository) :
    BaseViewModel<BaseNavigator>() {

    var token: String? = null
    var history = MutableLiveData<HistoryResponse>()
    fun getHistory(token: String?) {
        if (token != null) {
            viewModelScope.launch {
                history.postValue(repository.getHistory(token))
            }
            Log.e("response", (history.value?.data.toString()))


        }
    }
//
//    init {
//        getHistory(token)
//    }
}