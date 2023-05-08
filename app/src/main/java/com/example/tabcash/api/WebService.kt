package com.example.tabcash.api

import com.example.tabcash.api.model.HistoryResponse
import com.example.tabcash.api.model.LoginRequestBody
import com.example.tabcash.api.model.LoginResponse
import com.example.tabcash.api.model.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface WebService{
        //   https://tapcash.000webhostapp.com/api/tapcash/orange/v1/
        @POST("login")
        suspend fun login(@Body loginRequestBody: LoginRequestBody): LoginResponse

    @POST("register")
    suspend fun register(
    ): RegisterResponse

    @GET("/transcations")
    suspend fun getHistory(
    ): HistoryResponse


}