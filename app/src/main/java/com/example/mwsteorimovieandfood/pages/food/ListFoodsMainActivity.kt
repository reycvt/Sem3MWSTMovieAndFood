package com.example.mwsteorimovieandfood.pages.food

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
import com.example.mwsteorimovieandfood.pages.FoodAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListFoodsMainActivity : AppCompatActivity() {
    private val makananAdapter = FoodAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_foods_main)

        getDataMakanan()
        refreshLayoutMakanan()

        val btnadd= findViewById<Button>(R.id.btnAddMakanan)
        val btnback= findViewById<Button>(R.id.btnBackMain)
        val rvMakanan = findViewById<RecyclerView>(R.id.rvMakanan)
        btnadd.setOnClickListener {
            val intent = Intent(this, AddFoodsMainActivity::class.java)
            startActivity(intent)
            this.finish()
        }
        btnback.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            this.finish()
        }
        with(rvMakanan){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = makananAdapter
        }

    }
    private fun refreshLayoutMakanan(){
        val refreshLayout = findViewById<SwipeRefreshLayout>(R.id.refreshLayoutMakanan)

        refreshLayout.setOnRefreshListener {
            Toast.makeText(this, "Halaman berhasil di refresh", Toast.LENGTH_LONG).show()
            refreshLayout.isRefreshing=false
//            recreate()
            getDataMakanan()
        }
    }
    override fun onResume() {
        getDataMakanan()
        refreshLayoutMakanan()
        super.onResume()
    }
    private fun getDataMakanan(){
        val client = ApiConfig.getService().getDataMakanan()
        client.enqueue(object : Callback<GetFood> {
            override fun onResponse(call: Call<GetFood>, response: Response<GetFood>) {
                Log.e(ContentValues.TAG, response.body().toString())
                makananAdapter.setData(response.body()!!.data)
            }

            override fun onFailure(call: Call<GetFood>, t: Throwable) {
                Log.e(ContentValues.TAG, "onFailure: ${t.message}")
            }
        })
    }
}