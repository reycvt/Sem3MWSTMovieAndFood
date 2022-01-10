package com.example.mwsteorimovieandfood.pages.bioskop

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.mwsteorimovieandfood.MainActivity
import com.example.mwsteorimovieandfood.R
import com.example.mwsteorimovieandfood.api.ApiConfig
import com.example.mwsteorimovieandfood.api.response.bioskop.GetBioskop

import com.example.mwsteorimovieandfood.pages.BioskopAdapter
//import com.example.mwsteorimovieandfood.api.response.bioskop.GetBioskopItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class LocationBioskopActivity : AppCompatActivity() {
    private val bioskopAdapter = BioskopAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_bioskop)

        getData()
        refreshLayout()

        val btnadd= findViewById<Button>(R.id.btnAddBioskop)
        val btnback= findViewById<Button>(R.id.btnBackMain)
        val rvBioskop = findViewById<RecyclerView>(R.id.rvBioskop)

        btnadd.setOnClickListener {
            val intent = Intent(this, AddBioskopMainActivity::class.java)
            startActivity(intent)
            this.finish()
        }
        btnback.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            this.finish()
        }
        with(rvBioskop){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = bioskopAdapter
        }

    }
    private fun refreshLayout(){
        val refreshLayout = findViewById<SwipeRefreshLayout>(R.id.refreshLayout)

        refreshLayout.setOnRefreshListener {
            Toast.makeText(this, "Halaman berhasil di refresh", Toast.LENGTH_LONG).show()
            refreshLayout.isRefreshing=false
//            recreate()
            getData()
        }
    }
    override fun onResume() {
        getData()
        refreshLayout()
        super.onResume()
    }
    private fun getData(){
        val client = ApiConfig.getService().getData()
        client.enqueue(object : Callback<GetBioskop>{
            override fun onResponse(call: Call<GetBioskop>, response: Response<GetBioskop>) {
                Log.e(TAG, response.body().toString())
                bioskopAdapter.setData(response.body()!!.data)
            }

            override fun onFailure(call: Call<GetBioskop>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
}
}