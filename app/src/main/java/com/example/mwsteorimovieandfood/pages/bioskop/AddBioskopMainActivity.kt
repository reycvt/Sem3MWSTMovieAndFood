package com.example.mwsteorimovieandfood.pages.bioskop

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.example.mwsteorimovieandfood.R
import com.example.mwsteorimovieandfood.api.ApiConfig
import com.example.mwsteorimovieandfood.api.response.bioskop.PostBioskop
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddBioskopMainActivity : AppCompatActivity() {
    companion object{
        const val TAG = "AddBioskopMainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_bioskop_main)
        val iNama= findViewById<EditText>(R.id.ENamaBioskop)
        val iStatus= findViewById<Spinner>(R.id.sp_Status)
        val iAlamat = findViewById<EditText>(R.id.EAlamat)
        val btnsmbt= findViewById<Button>(R.id.btnsubmitAddBioskop)

        btnsmbt.setOnClickListener {
            var nama = iNama.text.toString()
            var status =iStatus.selectedItem.toString()
            var alamat = iAlamat.text.toString()
            insertData(
                nama = nama,
                status = status,
                alamat = alamat
            )

            val intent = Intent(this, LocationBioskopActivity::class.java)
            startActivity(intent)
            finish()


        }

    }

    private fun insertData(
        nama: String,
        status: String,
        alamat: String,
    ){
        val client = ApiConfig.getService().insertBioskop(nama, status, alamat)
        client.enqueue(object : Callback<PostBioskop> {
            override fun onResponse(
                call: Call<PostBioskop>,
                response: Response<PostBioskop>
            ) {
                Log.e(AddBioskopMainActivity.TAG, response.body().toString())
            }

            override fun onFailure(call: Call<PostBioskop>, t: Throwable) {
                Log.e(AddBioskopMainActivity.TAG, "onFailure: ${t.message}")
            }
        })
    }
}