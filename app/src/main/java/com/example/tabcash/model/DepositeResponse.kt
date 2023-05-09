package com.example.tabcash.model

import com.google.gson.annotations.SerializedName

data class DepositeResponse(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class Data(

	@field:SerializedName("balance")
	val balance: String? = null,

	@field:SerializedName("deposit")
	val deposit: String? = null
)
