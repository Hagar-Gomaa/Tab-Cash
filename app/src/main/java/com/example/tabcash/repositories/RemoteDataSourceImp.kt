package com.example.tabcash.repositories

import com.example.tabcash.api.WebService
import com.example.tabcash.api.model.LoginRequestBody
import com.example.tabcash.api.model.LoginResponse
import com.example.tabcash.repositoryContract.RemoteDataSource
import com.route.news_app_c37.api.ApiManager
import javax.inject.Inject


class RemoteDataSourceImp @Inject constructor(val webService: WebService) :RemoteDataSource{
   override suspend fun login(loginRequestBody: LoginRequestBody): LoginResponse {
       return webService.login(loginRequestBody)
   }
}