package com.example.tabcash.model

import com.google.gson.annotations.SerializedName

data class TransferResponse(

    @field:SerializedName("data")
    val data: TransferData? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: Int? = null
)

data class TransferData(

    @field:SerializedName("amount")
    val amount: String? = null,

    @field:SerializedName("balanceBefore")
    val balanceBefore: String? = null,

    @field:SerializedName("blanceAfter")
    val blanceAfter: String? = null
)

