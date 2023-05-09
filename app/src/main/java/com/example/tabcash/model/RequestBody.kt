package com.example.tabcash.model

data class LoginRequestBody(val email: String?, val password: String?)
data class RegisterRequstBody(val name: String?, val email: String?,val password: String?, val phone: String?)

//data class TransferRequestBody(val amount: Int?, val phone: String?)
data class BalanceRequestBody(val token: String?)

data class TransferRequestBody(val amount: String?,val phone:String?)
