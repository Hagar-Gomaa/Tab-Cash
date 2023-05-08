package com.example.tabcash.model

import com.google.gson.annotations.SerializedName

data class RegisterErrorResponse(

	@field:SerializedName("data")
	val data: Any? = null,

	@field:SerializedName("message")
	val message: Message? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class Message(

	@field:SerializedName("password")
	val password: List<String?>? = null,

	@field:SerializedName("phone")
	val phone: List<String?>? = null,

	@field:SerializedName("email")
	val email: List<String?>? = null
)
data class LoginErrorResponse(

	@field:SerializedName("data")
	val data: Any? = null,

	@field:SerializedName("message")
	val message: LoginMessage? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class LoginMessage(

	@field:SerializedName("password")
	val password: List<String?>? = null,

	@field:SerializedName("email")
	val email: List<String?>? = null
)
