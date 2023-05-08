package com.example.tabcash.model

data class LoginRequestBody(val email: String?, val password: String?)
data class RegisterBody(val name: String?, val email: String?,val password: String?, val phone: String?)
data class TransferBody(val amount: Int?, val phone: String?)
data class BalanceBody(val token: String?)

