package com.example.tabcash.api.model

import com.google.gson.annotations.SerializedName

data class RegisterResponse(

	@field:SerializedName("authorisation")
	val authorisation: Authorisation? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("user")
	val user: User? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class RegisterUser(

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)

data class RegisterAuthorisation(

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("token")
	val token: String? = null
)
