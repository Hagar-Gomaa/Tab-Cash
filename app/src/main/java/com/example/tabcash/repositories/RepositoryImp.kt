package com.example.tabcash.repositories

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
}