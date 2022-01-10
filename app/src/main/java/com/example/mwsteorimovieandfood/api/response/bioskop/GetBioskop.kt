package com.example.mwsteorimovieandfood.api.response.bioskop

import com.google.gson.annotations.SerializedName

data class GetBioskop(

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

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("status")
	val status: String,

	@field:SerializedName("alamat")
	val alamat: String
)
