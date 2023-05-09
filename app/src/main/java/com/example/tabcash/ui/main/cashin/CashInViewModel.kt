package com.example.tabcash.ui.main.cashin

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
class CashInViewModel @Inject constructor(val repository: Repository) :
    BaseViewModel<BaseNavigator>() {

    val balance = ObservableField<String>()
    var token: String? = null
    var history = MutableLiveData<HistoryResponse>()

    fun getbalnce(token: String?) {

        if (token != null) {
            viewModelScope.launch {
                try {
                    balance.set(token.let { repository.getBalance(it).data?.balance } ?: "")
                    Log.e("balance", balance.get().toString())

                } catch (e: HttpException) {

                    navigator?.hideLoading()
                    navigator?.showMessage("Token is expired")

                } catch (e: Exception) {
                    e.localizedMessage?.let { Log.e("erorr", it) }
                    navigator?.hideLoading()
                    e.localizedMessage?.let { navigator?.showMessage(it.toString()) }

                }
            }}}}
//
//    init {
//        getHistory(token)
//    }
