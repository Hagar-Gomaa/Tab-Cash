package com.example.tabcash.repositories

import com.example.tabcash.api.model.LoginRequestBody
import com.example.tabcash.api.model.LoginResponse
import com.example.tabcash.repositoryContract.RemoteDataSource
import com.example.tabcash.repositoryContract.Repository
import javax.inject.Inject

class RepositoryImp @Inject constructor(val remoteDataSource: RemoteDataSource): Repository {
    override suspend fun login(loginRequestBody: LoginRequestBody):LoginResponse {
        return remoteDataSource.login(loginRequestBody)
    }
}