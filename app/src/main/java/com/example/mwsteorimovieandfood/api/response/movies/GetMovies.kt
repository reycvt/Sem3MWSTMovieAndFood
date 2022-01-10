package com.example.mwsteorimovieandfood.api.response.movies

import com.google.gson.annotations.SerializedName

data class GetMovies(

	@field:SerializedName("data")
	val data: List<DataItem>,

	@field:SerializedName("error")
	val error: Boolean,

	@field:SerializedName("message")
	val message: String
)

data class DataItem(

	@field:SerializedName("date")
	val date: String,

	@field:SerializedName("genre")
	val genre: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("judul")
	val judul: String,

	@field:SerializedName("durasi")
	val durasi: String
)
