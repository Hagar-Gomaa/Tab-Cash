package com.example.tabcash.repositories

import com.example.tabcash.model.BalanceResponse
import com.example.tabcash.model.DepositeResponse
import com.example.tabcash.model.HistoryResponse
import com.example.tabcash.model.LoginRequestBody
import com.example.tabcash.model.LoginResponse
import com.example.tabcash.model.RegisterBody
import com.example.tabcash.model.RegisterResponse
import com.example.tabcash.repositoryContract.RemoteDataSource
import com.example.tabcash.repositoryContract.Repository
import javax.inject.Inject


class RepositoryImp @Inject constructor(val remoteDataSource: RemoteDataSource): Repository {
    override suspend fun login(loginRequestBody: LoginRequestBody): LoginResponse {
        return remoteDataSource.login(loginRequestBody)
    }

    override suspend fun register(registerBody: RegisterBody): RegisterResponse {
        return remoteDataSource.register(registerBody)
    }

    override suspend fun getBalance(accessToken: String): BalanceResponse {
        return remoteDataSource.getBalance("Bearer $accessToken")
    }
    override suspend fun getHistory(accessToken: String): HistoryResponse {
        return remoteDataSource.getHistory("Bearer $accessToken")
    }

    override suspend fun deposite(accessToken: String, amount: Int): DepositeResponse {
        return remoteDataSource.deposite(accessToken,amount)
    }
}