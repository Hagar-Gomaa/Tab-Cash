package com.example.tabcash.repositoryContract

import com.example.tabcash.api.model.LoginResponse


interface RemoteDataSource {
    suspend fun login(): LoginResponse
}