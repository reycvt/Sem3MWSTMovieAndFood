package com.example.mwsteorimovieandfood.pages.movies

import android.app.DatePickerDialog
import android.content.ContentValues
import android.content.Intent
import android.os.Build.ID
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Spinner
import com.example.mwsteorimovieandfood.R
import com.example.mwsteorimovieandfood.api.ApiConfig
import com.example.mwsteorimovieandfood.api.response.food.PostFood
import com.example.mwsteorimovieandfood.api.response.movies.PostMovies
import com.example.mwsteorimovieandfood.pages.food.ListFoodsMainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class AddMoviesActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movies)

        val inTglMovies=findViewById<EditText>(R.id.inptTanggalMovies)
        val iJudul = findViewById<EditText>(R.id.ETitle)
        val iGenre = findViewById<Spinner>(R.id.sp_Genre)
        val iDurasi= findViewById<EditText>(R.id.EDurasi)
        val btnsmbt = findViewById<Button>(R.id.btnsubmitAddMovies)
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        inTglMovies.setOnClickListener {
            val dpd = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    // Display Selected date in TextView
                    var monthInput = (monthOfYear + 1).toString()
                    if (monthInput.toInt() == 1) {
                        monthInput = "Jan"
                    } else if (monthInput.toInt() == 2) {
                        monthInput = "Feb"
                    } else if (monthInput.toInt() == 3) {
                        monthInput = "March"
                    } else if (monthInput.toInt() == 4) {
                        monthInput = "April"
                    } else if (monthInput.toInt() == 5) {
                        monthInput = "May"
                    } else if (monthInput.toInt() == 6) {
                        monthInput = "June"
                    } else if (monthInput.toInt() == 7) {
                        monthInput = "July"
                    } else if (monthInput.toInt() == 8) {
                        monthInput = "Aug"
                    } else if (monthInput.toInt() == 9) {
                        monthInput = "Sept"
                    } else if (monthInput.toInt() == 10) {
                        monthInput = "Oct"
                    } else if (monthInput.toInt() == 11) {
                        monthInput = "Nov"
                    } else if (monthInput.toInt() == 12) {
                        monthInput = "Dec"
                    }
                    inTglMovies.setText(""+dayOfMonth+","+ monthInput+","+ year)
                }, year, month, day)
//            display.datePicker.minDate = System.currentTimeMillis()
            dpd.show()
        }

        btnsmbt.setOnClickListener {
            var judul = iJudul.text.toString()
            var genre =iGenre.selectedItem.toString()
            var durasi = iDurasi.text.toString()
            var tanggal = inTglMovies.text.toString()
            insertDataMovies(
                judul = judul,
                genre = genre,
                durasi = durasi,
                date = tanggal
            )

            val intent = Intent(this, MoviesActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun insertDataMovies(
        judul: String,
        genre: String,
        durasi: String,
        date : String,
    ){
        val client = ApiConfig.getService().insertMovies(judul,genre,durasi,date)
        client.enqueue(object : Callback<PostMovies> {
            override fun onResponse(
                call: Call<PostMovies>,
                response: Response<PostMovies>
            ) {
                Log.e(ContentValues.TAG, response.body().toString())
            }
            override fun onFailure(call: Call<PostMovies>, t: Throwable) {
                Log.e(ContentValues.TAG, "onFailure: ${t.message}")
            }
        })
    }
}