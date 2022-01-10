package com.example.mwsteorimovieandfood.pages.movies

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.mwsteorimovieandfood.MainActivity
import com.example.mwsteorimovieandfood.R
import com.example.mwsteorimovieandfood.api.ApiConfig
import com.example.mwsteorimovieandfood.api.response.food.GetFood
import com.example.mwsteorimovieandfood.api.response.movies.GetMovies
import com.example.mwsteorimovieandfood.pages.FoodAdapter
import com.example.mwsteorimovieandfood.pages.MoviesAdapter
import com.example.mwsteorimovieandfood.pages.food.AddFoodsMainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesActivity : AppCompatActivity() {
    private val moviesAdapter = MoviesAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        getDataMovies()
        refreshLayoutMovies()

        val btnadd= findViewById<Button>(R.id.btnAddMovies)
        val btnback= findViewById<Button>(R.id.btnBackMain)
        val rvMovies = findViewById<RecyclerView>(R.id.rvMovies)
        btnadd.setOnClickListener {
            val intent = Intent(this, AddMoviesActivity::class.java)
            startActivity(intent)
            this.finish()
        }
        btnback.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            this.finish()
        }
        with(rvMovies){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = moviesAdapter
        }
    }
    private fun refreshLayoutMovies(){
        val refreshLayout = findViewById<SwipeRefreshLayout>(R.id.refreshLayoutMovies)

        refreshLayout.setOnRefreshListener {
            Toast.makeText(this, "Halaman berhasil di refresh", Toast.LENGTH_LONG).show()
            refreshLayout.isRefreshing=false
//            recreate()
            getDataMovies()
        }
    }
    override fun onResume() {
        getDataMovies()
        refreshLayoutMovies()
        super.onResume()
    }
    private fun getDataMovies(){
        val client = ApiConfig.getService().getDataMovies()
        client.enqueue(object : Callback<GetMovies> {
            override fun onResponse(call: Call<GetMovies>, response: Response<GetMovies>) {
                Log.e(ContentValues.TAG, response.body().toString())
                moviesAdapter.setData(response.body()!!.data)
            }

            override fun onFailure(call: Call<GetMovies>, t: Throwable) {
                Log.e(ContentValues.TAG, "onFailure: ${t.message}")
            }
        })
    }


}