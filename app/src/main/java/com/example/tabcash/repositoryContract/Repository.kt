package com.example.tabcash.repositoryContract

import com.example.tabcash.model.BalanceResponse
import com.example.tabcash.model.DepositeResponse
import com.example.tabcash.model.HistoryResponse
import com.example.tabcash.model.LoginRequestBody
import com.example.tabcash.model.LoginResponse
import com.example.tabcash.model.RegisterBody
import com.example.tabcash.model.RegisterResponse
import com.example.tabcash.model.TransferBody


interface Repository {
    suspend fun login(loginRequestBody: LoginRequestBody): LoginResponse
    suspend fun register(registerBody: RegisterBody): RegisterResponse
    suspend fun getBalance(accessToken: String): BalanceResponse
    suspend fun getHistory(accessToken: String): HistoryResponse

    suspend fun deposite(accessToken: String ,amount:String): DepositeResponse


//    suspend fun getTransactions(): HistoryResponse


//    suspend fun transfer(transferBody: TransferBody):
}