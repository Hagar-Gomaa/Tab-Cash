package com.example.tabcash.utils

import android.content.Context

class MySharedPreferences(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        val editor = sharedPreferences.edit()
        editor.putString("token", token)
        editor.apply()
    }

    fun getToken(): String? {
        return sharedPreferences.getString("token", null)
    }

    fun saveBalance(balance: String) {
        val editor = sharedPreferences.edit()
        editor.putString("balance", balance)
        editor.apply()
    }

    fun getBalance(): String? {
        return sharedPreferences.getString("balance", null)
    }
    fun saveRememberme(rememberMe :Boolean) {
        val editor = sharedPreferences.edit()
        editor.putString("rememberMeValue", rememberMe.toString())
        editor.apply()
    }

    fun getRememberme(): String? {
        return sharedPreferences.getString("rememberMeValue", null)
    }
}