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
import com.example.mwsteorimovieandfood.api.response.bioskop.PostBioskop2
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateBioskopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_bioskop)

        val iNama = findViewById<EditText>(R.id.ENamaBioskop)
        val iStatus = findViewById<Spinner>(R.id.sp_Status)
        val iAlamat = findViewById<EditText>(R.id.EAlamatBioskop)
        val TvId = findViewById<TextView>(R.id.TvIdUBioskop)
        val btnsmbt = findViewById<Button>(R.id.btnsubmitUpBioskop)

        var nama = intent.getStringExtra("Key_NamaBioskop")
        var id = intent.getStringExtra("Key_Id")
        var alamat = intent.getStringExtra("Key_AlamatBioskop")

        iNama.setText(nama)
        iAlamat.setText(alamat)
        TvId.text=id

        btnsmbt.setOnClickListener {
            var nama = iNama.text.toString()
            var status = iStatus.selectedItem.toString()
            var alamat = iAlamat.text.toString()
            var id = TvId.text.toString()
            UpdateData(
                id = id,
                nama = nama,
                status = status,
                alamat = alamat
            )

            val intent = Intent(this, LocationBioskopActivity::class.java)
            startActivity(intent)
            finish()


        }
    }
    private fun UpdateData(
        id: String,
        nama: String,
        status: String,
        alamat: String,
    ){
        val client = ApiConfig.getService().updateBioskop(id,nama, status, alamat)
        client.enqueue(object : Callback<PostBioskop2> {
            override fun onResponse(
                call: Call<PostBioskop2>,
                response: Response<PostBioskop2>
            ) {
                Log.e(TAG, response.body().toString())
            }

            override fun onFailure(call: Call<PostBioskop2>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }
}