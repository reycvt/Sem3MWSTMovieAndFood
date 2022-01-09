package com.example.mwsteorimovieandfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mwsteorimovieandfood.pages.bioskop.LocationBioskopActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMovies= findViewById<Button>(R.id.btnMovie)
        val btnBioskop = findViewById<Button>(R.id.btnLoc)
        val btnFood = findViewById<Button>(R.id.btnFood)
        btnBioskop.setOnClickListener {
            val intent = Intent(this, LocationBioskopActivity::class.java)
            startActivity(intent)
            this.recreate()

        }

    }
}