package com.example.mwsteorimovieandfood.pages.food

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import com.example.mwsteorimovieandfood.R
import com.example.mwsteorimovieandfood.api.ApiConfig
import com.example.mwsteorimovieandfood.api.response.bioskop.PostBioskop
import com.example.mwsteorimovieandfood.api.response.food.PostFood
import com.example.mwsteorimovieandfood.pages.bioskop.AddBioskopMainActivity
import com.example.mwsteorimovieandfood.pages.bioskop.LocationBioskopActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddFoodsMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_foods_main)
        val iNama = findViewById<EditText>(R.id.ENamaMakanan)
        val iStatus = findViewById<Spinner>(R.id.sp_StatusMakanan)
        val iHarga= findViewById<EditText>(R.id.EHarga)
        val btnsmbt = findViewById<Button>(R.id.btnsubmitAddMkn)

        btnsmbt.setOnClickListener {
            var nama = iNama.text.toString()
            var status =iStatus.selectedItem.toString()
            var harga = iHarga.text.toString()
            insertDataMakanan(
                nama = nama,
                status = status,
                harga = harga
            )

            val intent = Intent(this, ListFoodsMainActivity::class.java)
            startActivity(intent)
            finish()


        }

    }
    private fun insertDataMakanan(
        nama: String,
        status: String,
        harga: String,
    ){
        val client = ApiConfig.getService().insertMakanan(nama, status, harga)
        client.enqueue(object : Callback<PostFood> {
            override fun onResponse(
                call: Call<PostFood>,
                response: Response<PostFood>
            ) {
                Log.e(TAG, response.body().toString())
            }

            override fun onFailure(call: Call<PostFood>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }
}