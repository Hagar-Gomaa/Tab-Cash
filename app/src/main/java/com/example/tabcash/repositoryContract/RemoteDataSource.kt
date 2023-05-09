package com.example.tabcash.repositoryContract

import com.example.tabcash.model.BalanceResponse
import com.example.tabcash.model.DepositeResponse
import com.example.tabcash.model.HistoryResponse
import com.example.tabcash.model.LoginRequestBody
import com.example.tabcash.model.LoginResponse
import com.example.tabcash.model.RegisterRequstBody
import com.example.tabcash.model.RegisterResponse
import com.example.tabcash.model.TransferRequestBody
import com.example.tabcash.model.TransferResponse


interface RemoteDataSource {
    suspend fun login(loginRequestBody: LoginRequestBody): LoginResponse
    suspend fun register(registerBody:RegisterRequstBody): RegisterResponse
    suspend fun getBalance(accessToken: String): BalanceResponse
    suspend fun deposite(accessToken: String ,amount:Int): DepositeResponse
    suspend fun getHistory(ccessToken: String): HistoryResponse
    suspend fun transfer(accessToken: String,transferRequestBody: TransferRequestBody): TransferResponse

}