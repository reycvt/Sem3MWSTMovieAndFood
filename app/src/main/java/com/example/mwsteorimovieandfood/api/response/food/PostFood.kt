package com.example.mwsteorimovieandfood.api.response.food

import com.google.gson.annotations.SerializedName

data class PostFood(

	@field:SerializedName("error")
	val error: Boolean? = null,

	@field:SerializedName("message")
	val message: Message? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class Message(

	@field:SerializedName("success")
	val success: String? = null
)
