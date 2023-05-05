package com.example.tabcash.api.model

import com.google.gson.annotations.SerializedName

data class HistoryResponse(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class DataItem(

	@field:SerializedName("amount")
	val amount: String? = null,

	@field:SerializedName("time")
	val time: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("confirmed")
	val confirmed: Boolean? = null
)
