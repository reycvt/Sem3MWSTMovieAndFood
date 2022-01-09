package com.example.mwsteorimovieandfood.pages.bioskop

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mwsteorimovieandfood.R
import com.example.mwsteorimovieandfood.api.ApiConfig
import com.example.mwsteorimovieandfood.api.response.bioskop.DataItem
import com.example.mwsteorimovieandfood.api.response.bioskop.GetBioskop
import com.example.mwsteorimovieandfood.model.BioskopModel
import com.example.mwsteorimovieandfood.pages.BioskopAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LocationBioskopActivity : AppCompatActivity() {
//    private val bioskopAdapter = BioskopAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_bioskop)

        getData()

        val btnadd= findViewById<Button>(R.id.btnAdd)
        val rvBioskop = findViewById<RecyclerView>(R.id.rvBioskop)

//        btnadd.setOnClickListener {
//            val intent = Intent(this, AddBioskopMainActivity::class.java)
//            startActivity(intent)
//            this.recreate()
//        }
//        with(rvBioskop){
//            layoutManager = LinearLayoutManager(context)
//            setHasFixedSize(true)
//            adapter = bioskopAdapter
//        }

    }
    private fun getData(){
        val listData = ArrayList<BioskopModel>()
        val rvStudentData : RecyclerView = findViewById(R.id.rvBioskop)
        rvStudentData.setHasFixedSize(true)
        rvStudentData.layoutManager = LinearLayoutManager(this)
        val tvnama = findViewById<TextView>(R.id.tvTitleBioskop)
        val tvstatus = findViewById<TextView>(R.id.tvStatus)
        val tvalamat = findViewById<TextView>(R.id.tvAlamat)



        val apiClient = ApiConfig.getService()
        val callData = apiClient.getData()

        callData.enqueue(object : Callback<ArrayList<BioskopModel>>{
            override fun onResponse(
                call: Call<ArrayList<BioskopModel>>,
                response: Response<ArrayList<BioskopModel>>
            ) {
                val data = response.body()
//                tvstatuscode.text=response.code().toString()
                data?.let { listData.addAll(it) }

                val adapterData = BioskopAdapter(listData)
                rvStudentData.adapter = adapterData

                Log.d("TAG",response.code().toString())
            }

            override fun onFailure(call: Call<ArrayList<BioskopModel>>, t: Throwable) {
                Log.e("TAG", "onFailure: ${t.message}")
//                tvstatuscode.text=t.message.toString()
            }

        })
}
}