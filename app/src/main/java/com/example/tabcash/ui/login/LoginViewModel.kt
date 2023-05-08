package com.example.tabcash.ui.login

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import com.example.tabcash.isValidEmail
import com.example.tabcash.model.LoginErrorResponse
import com.example.tabcash.model.LoginRequestBody
import com.example.tabcash.model.LoginResponse
import com.example.tabcash.model.RegisterErrorResponse
import com.example.tabcash.repositoryContract.Repository
import com.example.tabcash.ui.base.BaseViewModel
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val repository: Repository) :
    BaseViewModel<LoginNavigator>() {

    val email = ObservableField<String>()
    val emailError = ObservableField<String?>()
    val password = ObservableField<String>()
    val passwordError = ObservableField<String?>()
    fun login() {
        if (!validForm()) return
        navigator?.showLoading("Loading...")
        callRepository()

    }

    private fun callRepository() {
        viewModelScope.launch {
            try {
                val token = repository.login(
                    LoginRequestBody(
                        email.get(),
                        password.get()
                    )
                ).authorisation?.token.toString()
//                newsList.value = news
                Log.e("result", token)
                navigator?.hideLoading()
                navigator?.goToHome()

            } catch (e: HttpException) {

                navigator?.hideLoading()
            navigator?.showMessage("Unauthorized")

            } catch (e: Exception) {
                e.localizedMessage?.let { Log.e("erorr", it) }
                navigator?.hideLoading()
                e.localizedMessage?.let { navigator?.showMessage(it.toString()) }

            }
        }
    }

    fun validForm(): Boolean {
        var isValid = true;
        if (email.get().isNullOrBlank()) {
            emailError.set("Please enter your email")
            isValid = false;
        } else if (email.get()?.isValidEmail() == false) {
            emailError.set("Please enter a valid email")
            isValid = false;

        } else {
            isValid = true;
            emailError.set(null)
        }

        if (password.get().isNullOrBlank()) {
            isValid = false
            passwordError.set("please enter password")
        } else {
            isValid = true
            passwordError.set(null)
        }

        return isValid;

    }

    fun gotoRegister() {
        navigator?.goToRegister()
    }

}