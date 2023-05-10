package com.example.tabcash.ui.cashin

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.tabcash.model.HistoryResponse
import com.example.tabcash.repositoryContract.Repository
import com.example.tabcash.ui.base.BaseNavigator
import com.example.tabcash.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class CashInViewModel @Inject constructor(val repository: Repository) :
    BaseViewModel<BaseNavigator>() {

    val balance = ObservableField<String>()
    val amount = ObservableField<String>()
    val amountError = ObservableField<String>()

    var token: String? = null
    var history = MutableLiveData<HistoryResponse>()
    private var cashInNavigator: CashInNavigator? = null
    fun getbalnce(token: String?) {

            viewModelScope.launch {
                try {
                    balance.set(token.let { repository.getBalance(token!!).data?.balance } ?: "")
//                Log.e("token", token.toString())

                    Log.e("balanceeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee", balance.get().toString())
                } catch (e: HttpException) {

                    navigator?.hideLoading()
                    navigator?.showMessage("Token is expired")

                } catch (e: Exception) {
                    e.localizedMessage?.let { Log.e("erorr", it) }
                    navigator?.hideLoading()
                    e.localizedMessage?.let { navigator?.showMessage(it.toString()) }

                }

        }
    }

    fun deposite(token: String?, amount: Int) {

        if (token != null) {
            viewModelScope.launch {
                try {
                    val response = repository.deposite(token, amount)
                    navigator?.hideLoading()
                    navigator?.showMessage("Money has transfered successfully")
                    balance.set(response.data?.balance)
                    cashInNavigator?.goToTransactions()
                } catch (e: HttpException) {
                    navigator?.hideLoading()
                    navigator?.showMessage("Token is expired")

                } catch (e: Exception) {
                    e.localizedMessage?.let { Log.e("erorr", it) }
                    navigator?.hideLoading()
                    e.localizedMessage?.let { navigator?.showMessage(it) }

                }
            }
        }
    }


    private fun validForm(): Boolean {
        var isValid = true
        if (amount.get().isNullOrBlank()) {
            isValid = false
            amountError.set("please enter amount value")
        } else {
            isValid = true
            amountError.set(null)
        }
        return isValid
    }
}

interface CashInNavigator {
    fun goToTransactions()
}
//
//    init {
//        getHistory(token)
//    }
