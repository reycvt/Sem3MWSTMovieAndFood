package com.example.mwsteorimovieandfood.pages.food

import android.content.ContentValues
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
import com.example.mwsteorimovieandfood.api.response.bioskop.PostBioskop2
import com.example.mwsteorimovieandfood.api.response.food.PostFood
import com.example.mwsteorimovieandfood.api.response.food.PostFood2
import com.example.mwsteorimovieandfood.pages.bioskop.LocationBioskopActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateFoodsMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_foods_main)

        val iNama = findViewById<EditText>(R.id.ENamaMakanan)
        val iStatus = findViewById<Spinner>(R.id.sp_StatusMakanan)
        val iHarga= findViewById<EditText>(R.id.EHargaMakanan)
        val TvId = findViewById<TextView>(R.id.TvIdUMakanan)
        val btnsmbt = findViewById<Button>(R.id.btnsubmitUpMkn)

        var nama = intent.getStringExtra("Key_NamaMakanan")
        var id = intent.getStringExtra("Key_IdMakanan")
        var harga = intent.getStringExtra("Key_HargaMakanan")

        iNama.setText(nama)
        iHarga.setText(harga)
        TvId.text=id

        btnsmbt.setOnClickListener {
            var nama = iNama.text.toString()
            var status = iStatus.selectedItem.toString()
            var harga = iHarga.text.toString()
            var id = TvId.text.toString()
            UpdateDataMakanan(
                id = id,
                nama = nama,
                status = status,
                harga = harga
            )

            val intent = Intent(this, ListFoodsMainActivity::class.java)
            startActivity(intent)
            finish()


        }


    }
    private fun UpdateDataMakanan(
        id: String,
        nama: String,
        status: String,
        harga: String,
    ){
        val client = ApiConfig.getService().updateMakanan(id,nama, status, harga)
        client.enqueue(object : Callback<PostFood2> {
            override fun onResponse(
                call: Call<PostFood2>,
                response: Response<PostFood2>
            ) {
                Log.e(ContentValues.TAG, response.body().toString())
            }

            override fun onFailure(call: Call<PostFood2>, t: Throwable) {
                Log.e(ContentValues.TAG, "onFailure: ${t.message}")
            }
        })
    }
}