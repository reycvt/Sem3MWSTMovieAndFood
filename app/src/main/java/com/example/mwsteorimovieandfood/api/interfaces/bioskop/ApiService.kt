package com.example.mwsteorimovieandfood.api.interfaces.bioskop

import com.example.mwsteorimovieandfood.api.response.bioskop.DataItem
import com.example.mwsteorimovieandfood.api.response.bioskop.GetBioskop
import retrofit2.Call
import retrofit2.http.*
import com.example.mwsteorimovieandfood.api.response.bioskop.PostBioskop
import com.example.mwsteorimovieandfood.api.response.bioskop.PostBioskop2
import com.example.mwsteorimovieandfood.api.response.food.GetFood
import com.example.mwsteorimovieandfood.api.response.food.PostFood
import com.example.mwsteorimovieandfood.api.response.food.PostFood2
import com.example.mwsteorimovieandfood.api.response.movies.GetMovies
import com.example.mwsteorimovieandfood.api.response.movies.PostMovies
import com.example.mwsteorimovieandfood.api.response.movies.PostMovies2

interface ApiService {
    @GET("bioskop")
    fun getData(): Call<GetBioskop>

    @FormUrlEncoded
    @POST("bioskop/create")
    fun insertBioskop(
        @Field("nama") nama: String?,
        @Field("status") status: String?,
        @Field("alamat") alamat: String?,
    ): Call<PostBioskop>

    @FormUrlEncoded
    @POST("bioskop/update/{id}")
    fun updateBioskop(
        @Path("id") id : String,
//        @Field("id") id1 : Int,
        @Field("nama") nama: String,
        @Field("status") status: String,
        @Field("alamat") alamat: String,
    ): Call<PostBioskop2>

    @DELETE("bioskop/{id}")
    fun deleteBioskop(
        @Path("id")id: Int
    ): Call<PostBioskop>

//=================== Makanan =====================//

    @GET("makanan")
    fun getDataMakanan(): Call<GetFood>

    @FormUrlEncoded
    @POST("makanan/create")
    fun insertMakanan(
        @Field("nama") nama: String?,
        @Field("status") status: String?,
        @Field("harga") harga: String?,
    ): Call<PostFood>

    @FormUrlEncoded
    @POST("makanan/update/{id}")
    fun updateMakanan(
        @Path("id") id : String,
//        @Field("id") id1 : Int,
        @Field("nama") nama: String?,
        @Field("status") status: String?,
        @Field("alamat") harga: String?,
    ): Call<PostFood2>

    @DELETE("makanan/{id}")
    fun deleteMakanan(
        @Path("id")id: Int
    ): Call<PostFood>

    //=================== Movies =====================//

    @GET("movies")
    fun getDataMovies(): Call<GetMovies>

    @FormUrlEncoded
    @POST("movies/create")
    fun insertMovies(
        @Field("judul") judul: String?,
        @Field("genre") genre: String?,
        @Field("durasi") durasi: String?,
        @Field("date") date: String?,
    ): Call<PostMovies>

    @FormUrlEncoded
    @POST("movies/update/{id}")
    fun updateMovies(
        @Path("id") id : String,
//        @Field("id") id1 : Int,
        @Field("judul") judul: String?,
        @Field("genre") genre: String?,
        @Field("durasi") durasi: String?,
        @Field("date") date: String?,
    ): Call<PostMovies2>

    @DELETE("movies/{id}")
    fun deleteMovies(
        @Path("id")id: Int
    ): Call<PostMovies>
}