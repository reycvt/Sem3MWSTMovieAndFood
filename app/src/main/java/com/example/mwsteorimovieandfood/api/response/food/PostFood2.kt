package com.example.mwsteorimovieandfood.api.response.food

import com.google.gson.annotations.SerializedName

data class PostFood2(

	@field:SerializedName("error")
	val error: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)
