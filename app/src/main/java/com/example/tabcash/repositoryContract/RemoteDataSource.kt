package com.example.tabcash.repositoryContract

import com.example.tabcash.api.model.LoginRequestBody
import com.example.tabcash.api.model.LoginResponse


interface RemoteDataSource {
    suspend fun login(loginRequestBody: LoginRequestBody): LoginResponse
}