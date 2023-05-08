package com.example.tabcash.api

import com.example.tabcash.model.HistoryResponse
import com.example.tabcash.model.LoginRequestBody
import com.example.tabcash.model.LoginResponse
import com.example.tabcash.model.RegisterBody
import com.example.tabcash.model.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface WebService{
        //   https://tapcash.000webhostapp.com/api/tapcash/orange/v1/
        @POST("login")
        suspend fun login(@Body loginRequestBody: LoginRequestBody): LoginResponse

    @POST("register")
    suspend fun register(@Body registerBody: RegisterBody): RegisterResponse

    @GET("/transcations")
    suspend fun getHistory(
    ): HistoryResponse


}