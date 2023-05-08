package com.example.tabcash.ui.login

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tabcash.api.model.LoginRequestBody
import com.example.tabcash.api.model.LoginResponse
import com.example.tabcash.ui.base.BaseViewModel
import com.example.tabcash.isValidEmail
import com.example.tabcash.repositoryContract.Repository
import com.google.gson.Gson
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject
@HiltViewModel
class LoginViewModel @Inject constructor( val repository: Repository) :
    BaseViewModel<LoginNavigator>(){

    val email = ObservableField<String>()
    val emailError = ObservableField<String?>()
    val password = ObservableField<String>()
    val passwordError = ObservableField<String?>()
    fun login() {
        if (!validForm()) return
        navigator?.showLoading("Loading...")
        callRepository()

    }

    fun callRepository() {
        viewModelScope.launch {
            try {
                val token = repository.login(LoginRequestBody(email.get(),password.get())).authorisation?.token.toString()
//                newsList.value = news
                Log.e("result",token)

                navigator?.hideLoading()
                navigator?.goToHome()

            } catch (e: HttpException) {
                val errorResponse = Gson().fromJson(
                    e.response()?.errorBody()?.string(), LoginResponse::class.java
                )
              Log.e("erorr",errorResponse.status.toString())
            } catch (e: Exception) {
                Log.e("erorr",e.localizedMessage.toString())
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
            emailError.set(null) }

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