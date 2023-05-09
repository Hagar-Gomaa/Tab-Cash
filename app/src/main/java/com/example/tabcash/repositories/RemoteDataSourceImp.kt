package com.example.tabcash.repositories

import com.example.tabcash.api.WebService
import com.example.tabcash.model.BalanceResponse
import com.example.tabcash.model.DepositeResponse
import com.example.tabcash.model.HistoryResponse
import com.example.tabcash.model.LoginRequestBody
import com.example.tabcash.model.LoginResponse
import com.example.tabcash.model.RegisterBody
import com.example.tabcash.model.RegisterResponse
import com.example.tabcash.repositoryContract.RemoteDataSource
import javax.inject.Inject


class RemoteDataSourceImp @Inject constructor(val webService: WebService) :RemoteDataSource{
   override suspend fun login(loginRequestBody: LoginRequestBody): LoginResponse {
       return webService.login(loginRequestBody)
   }

    override suspend fun register(registerBody: RegisterBody): RegisterResponse {
        return webService.register(registerBody)    }

    override suspend fun getBalance(accessToken: String): BalanceResponse {
        return webService.getBalance("Bearer $accessToken")
    }
    override suspend fun getHistory(ccessToken: String): HistoryResponse {
        return webService.getHistory("Bearer $ccessToken")
    }
    override suspend fun deposite(accessToken: String, amount: String): DepositeResponse {
        return webService.deposit(accessToken,amount)
    }

}