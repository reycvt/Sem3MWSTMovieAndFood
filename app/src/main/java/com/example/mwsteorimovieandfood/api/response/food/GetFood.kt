package com.example.mwsteorimovieandfood.api.response.food

import com.google.gson.annotations.SerializedName

data class GetFood(

	@field:SerializedName("data")
	val data: List<DataItem>,

	@field:SerializedName("error")
	val error: Boolean,

	@field:SerializedName("message")
	val message: String
)

data class DataItem(

	@field:SerializedName("nama")
	val nama: String,

	@field:SerializedName("harga")
	val harga: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("status")
	val status: String
)
