package com.example.tabcash.repositories

import com.example.tabcash.model.BalanceResponse
import com.example.tabcash.model.DepositeResponse
import com.example.tabcash.model.HistoryResponse
import com.example.tabcash.model.LoginRequestBody
import com.example.tabcash.model.LoginResponse
import com.example.tabcash.model.RegisterRequstBody
import com.example.tabcash.model.RegisterResponse
import com.example.tabcash.model.TransferRequestBody
import com.example.tabcash.model.TransferResponse
import com.example.tabcash.repositoryContract.RemoteDataSource
import com.example.tabcash.repositoryContract.Repository
import javax.inject.Inject


class RepositoryImp @Inject constructor(val remoteDataSource: RemoteDataSource): Repository {
    override suspend fun login(loginRequestBody: LoginRequestBody): LoginResponse {
        return remoteDataSource.login(loginRequestBody)
    }

    override suspend fun register(registerBody: RegisterRequstBody): RegisterResponse {
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

    override suspend fun transfer(accessToken: String,transferRequestBody: TransferRequestBody): TransferResponse {
        return remoteDataSource.transfer("Bearer $accessToken",transferRequestBody)
    }
}