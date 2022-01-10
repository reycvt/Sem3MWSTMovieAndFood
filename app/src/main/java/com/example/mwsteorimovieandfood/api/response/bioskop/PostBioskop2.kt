package com.example.mwsteorimovieandfood.api.response.bioskop

import com.google.gson.annotations.SerializedName

data class PostBioskop2(

	@field:SerializedName("error")
	val error: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)
