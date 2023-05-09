package com.example.tabcash.api

import com.example.tabcash.model.BalanceResponse
import com.example.tabcash.model.DepositeResponse
import com.example.tabcash.model.HistoryResponse
import com.example.tabcash.model.LoginRequestBody
import com.example.tabcash.model.LoginResponse
import com.example.tabcash.model.RegisterRequstBody
import com.example.tabcash.model.RegisterResponse
import com.example.tabcash.model.TransferRequestBody
import com.example.tabcash.model.TransferResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST


interface WebService{
        //   https://tapcash.000webhostapp.com/api/tapcash/orange/v1/
        @POST("login")
        suspend fun login(@Body loginRequestBody: LoginRequestBody): LoginResponse

    @POST("register")
    suspend fun register(@Body registerBody: RegisterRequstBody): RegisterResponse

    @GET("transcations")
    suspend fun getHistory(@Header("Authorization") token: String
    ): HistoryResponse

    @GET("balance")
    suspend fun getBalance(@Header("Authorization") token: String)
    : BalanceResponse

    @POST("transfer")
    suspend fun transfer(
        @Header("Authorization") token: String,
        @Body transferRequestResponse: TransferRequestBody
    ): TransferResponse

    @POST("deposit")
    suspend fun deposit(
        @Header("Authorization") token: String,
        @Body amount: Int
    ): DepositeResponse

//    @POST("deposit")
//    suspend fun transfer(
//        @Header("Authorization") token: String,
//        @Body amount: String
//    ): Response
}