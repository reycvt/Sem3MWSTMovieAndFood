package com.example.mwsteorimovieandfood.api.interfaces.bioskop

import com.example.mwsteorimovieandfood.api.response.bioskop.DataItem
import com.example.mwsteorimovieandfood.api.response.bioskop.GetBioskop
import retrofit2.Call
import retrofit2.http.*
import com.example.mwsteorimovieandfood.api.response.bioskop.PostBioskop
import com.example.mwsteorimovieandfood.model.BioskopModel

interface ApiService {
    @GET("bioskop")
    fun getData(): Call<ArrayList<BioskopModel>>

    @FormUrlEncoded
    @POST("/bioskop/create")
    fun insertBioskop(
        @Field("nama") nama: String,
        @Field("status") status: String,
        @Field("alamat") alamat: String,
    ): Call<PostBioskop>

    @FormUrlEncoded
    @POST("/bioskop/update/{id}")
    fun updateBioskop(
        @Path("id") id : Int,
        @Field("nama") nama: String,
        @Field("status") status: String,
        @Field("alamat") alamat: String,
    ): Call<PostBioskop>

    @GET("/bioskop/delete/{id}")
    fun deleteWebinar(
        @Query("id")id: Int
    ): Call<PostBioskop>

}