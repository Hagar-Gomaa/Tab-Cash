package com.example.tabcash.ui.login

import android.content.Context
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import com.example.tabcash.isValidEmail
import com.example.tabcash.model.RegisterErrorResponse
import com.example.tabcash.model.RegisterRequstBody
import com.example.tabcash.model.RegisterResponse
import com.example.tabcash.repositoryContract.Repository
import com.example.tabcash.ui.base.BaseViewModel
import com.example.tabcash.ui.register.RegisterNavigator
import com.example.tabcash.utils.MySharedPreferences
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val repository: Repository) :
    BaseViewModel<RegisterNavigator>() {

    val name = ObservableField<String>()
    val nameError = ObservableField<String?>()
    val email = ObservableField<String>()
    val emailError = ObservableField<String?>()
    val phone = ObservableField<String>()
    val phoneError = ObservableField<String?>()
    val password = ObservableField<String>()
    val passwordError = ObservableField<String?>()
    val confirmPassword = ObservableField<String>()
    val confirmPasswordError = ObservableField<String?>()
    val error = ObservableField<String>()
    var token:String?=null

    fun register() {
        if (!validForm()) return
        navigator?.showLoading("Loading...")
        callRepository()

    }

    private fun callRepository() {
        viewModelScope.launch {
            try {
                token = repository.register(
                    RegisterRequstBody(
                        name.get(),
                        email.get(),
                        password.get(),
                        phone.get()
                    )
                ).authorisation?.token.toString()
                Log.e("token", token!!)
                navigator?.hideLoading()
                navigator?.goToHome()

            } catch (e: HttpException) {
                val errorResponse = Gson().fromJson(
                    e.response()?.errorBody()?.string(), RegisterErrorResponse::class.java
                )
                if (errorResponse.message.toString() != "User created successfully") {
                    emailError.set(errorResponse.message?.email?.toString() ?: "")
                    phoneError.set(errorResponse.message?.phone?.toString() ?: "")
                    passwordError.set(errorResponse.message?.password?.toString() ?: "")
                    Log.e("error", errorResponse.message.toString())
                    navigator?.hideLoading()
//                navigator?.showMessage(errorResponse.message.toString())
                    Log.e("error", errorResponse.message.toString())
                }

            } catch (e: Exception) {
                Log.e("error", e.localizedMessage!!.toString())
                navigator?.showMessage(e.localizedMessage!!.toString())
            }
        }
    }

    private fun validForm(): Boolean {
        var isValid = true
        if (name.get().isNullOrBlank()) {
            isValid = false
            nameError.set("please enter your name")
        } else {
            isValid = true
            nameError.set(null)
        }
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

        if (phone.get().isNullOrBlank()) {
            isValid = false
            phoneError.set("please enter your phone")
        } else {
            isValid = true
            phoneError.set(null)
        }
        if (password.get().isNullOrBlank()) {
            isValid = false
            passwordError.set("please enter password")
        } else {
            isValid = true
            passwordError.set(null)
        }
        if (confirmPassword.get().isNullOrBlank()) {
            confirmPasswordError.set("Please enter your confirme password filed")
            isValid = false;
        } else if (confirmPassword.get() != password.get()) {
            confirmPasswordError.set("Please check if it equal password value")
            isValid = false;

        } else {
            isValid = true;
            confirmPassword.set(null)
        }

        return isValid;
    }

    fun goToLogin() {
        navigator?.goToLogin()
    }

}