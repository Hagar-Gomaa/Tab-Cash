package com.example.tabcash.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @field:SerializedName("authorisation")
    val authorisation: Authorisation? = null,

    @field:SerializedName("user")
    val user: User? = null,

    @field:SerializedName("status")
    val status: String? = null
)

data class User(

    @field:SerializedName("parent_user_id")
    val parentUserId: Any? = null,

    @field:SerializedName("phone")
    val phone: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("email_verified_at")
    val emailVerifiedAt: Any? = null,

    @field:SerializedName("email")
    val email: String? = null
)

data class Authorisation(

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("token")
    val token: String? = null
)
