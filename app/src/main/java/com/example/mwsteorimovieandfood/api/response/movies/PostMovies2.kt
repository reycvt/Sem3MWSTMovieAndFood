package com.example.mwsteorimovieandfood.api.response.movies

import com.google.gson.annotations.SerializedName

data class PostMovies2(

	@field:SerializedName("error")
	val error: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)
