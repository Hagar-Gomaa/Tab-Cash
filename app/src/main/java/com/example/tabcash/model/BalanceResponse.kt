package com.example.tabcash.model

import com.google.gson.annotations.SerializedName

data class BalanceResponse(

	@field:SerializedName("data")
	val data: BalanceData? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class BalanceData(

	@field:SerializedName("balance")
	val balance: String? = null
)
