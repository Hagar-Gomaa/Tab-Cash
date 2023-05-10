package com.example.tabcash.repositoryContract

import com.example.tabcash.model.BalanceResponse
import com.example.tabcash.model.DepositeResponse
import com.example.tabcash.model.HistoryResponse
import com.example.tabcash.model.LoginRequestBody
import com.example.tabcash.model.LoginResponse
import com.example.tabcash.model.RegisterBody
import com.example.tabcash.model.RegisterResponse


interface RemoteDataSource {
    suspend fun login(loginRequestBody: LoginRequestBody): LoginResponse
    suspend fun register(registerBody:RegisterBody): RegisterResponse
    suspend fun getBalance(accessToken: String): BalanceResponse
    suspend fun deposite(accessToken: String ,amount:Int): DepositeResponse

    suspend fun getHistory(ccessToken: String): HistoryResponse

}