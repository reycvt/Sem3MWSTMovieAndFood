package com.example.mwsteorimovieandfood.api.response.movies

import com.google.gson.annotations.SerializedName

data class PostMovies(

	@field:SerializedName("error")
	val error: Any,

	@field:SerializedName("message")
	val message: Message,

	@field:SerializedName("status")
	val status: Int
)

data class Message(

	@field:SerializedName("success")
	val success: String
)
