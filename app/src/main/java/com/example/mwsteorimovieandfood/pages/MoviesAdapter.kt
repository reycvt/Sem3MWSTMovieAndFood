package com.example.mwsteorimovieandfood.pages

import android.content.ContentValues
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mwsteorimovieandfood.R
import com.example.mwsteorimovieandfood.api.ApiConfig
import com.example.mwsteorimovieandfood.api.response.food.PostFood
import com.example.mwsteorimovieandfood.api.response.movies.DataItem
import com.example.mwsteorimovieandfood.api.response.movies.PostMovies
import com.example.mwsteorimovieandfood.pages.food.ListFoodsMainActivity
import com.example.mwsteorimovieandfood.pages.food.UpdateFoodsMainActivity
import com.example.mwsteorimovieandfood.pages.movies.MoviesActivity
import com.example.mwsteorimovieandfood.pages.movies.UpdateMoviesActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    private var data: ArrayList<DataItem> = arrayListOf()
    fun setData(data: List<DataItem>){
        this.data.clear()
        this.data.addAll(data)
        this.notifyDataSetChanged()
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvTitleMovies= itemView.findViewById<TextView>(R.id.tvTitleMovies)
        val tvGenre = itemView.findViewById<TextView>(R.id.tvgenre)
        val tvDurasi = itemView.findViewById<TextView>(R.id.tvDurasi)
        val tvTanggal= itemView.findViewById<TextView>(R.id.tvtanggalmovies)
        val btnUpdateMovies = itemView.findViewById<ImageButton>(R.id.btnUpdateMovies)
        val btnDeleteMovies = itemView.findViewById<ImageButton>(R.id.btndeleteMovies)
        val tvIdMovies = itemView.findViewById<TextView>(R.id.TvIdMovies)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.items_list_movies, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MoviesAdapter.ViewHolder, position: Int) {
        val itemData = data[position]
        holder.tvTitleMovies.text=itemData.judul
        holder.tvGenre.text = itemData.genre
        holder.tvDurasi.text = itemData.durasi
        holder.tvIdMovies.text = itemData.id
        holder.tvTanggal.text =itemData.date

        holder.btnUpdateMovies.setOnClickListener {
            val context=holder.itemView.context
            val intent = Intent( context, UpdateMoviesActivity::class.java)
            intent.putExtra("Key_IdMovies", holder.tvIdMovies.text)
            intent.putExtra("Key_JudulMovies", holder.tvTitleMovies.text)
//            intent.putExtra("Key_GenreMovies", holder.tvGenre.text)
            intent.putExtra("Key_DurasiMovies", holder.tvDurasi.text)
            intent.putExtra("Key_DateMovies", holder.tvTanggal.text)
//            intent.putExtra("Key_Gender", holder.tvJenisKelamin.text)
            context.startActivity(intent)


        }
        //        Action on button delete
        holder.btnDeleteMovies.setOnClickListener {
            val id = holder.tvIdMovies.text.toString().toInt()
            ApiConfig.getService().deleteMovies(id = id).enqueue(object :
                Callback<PostMovies> {
                override fun onResponse(
                    call: Call<PostMovies>,
                    response: Response<PostMovies>
                ) {
                    Log.e(ContentValues.TAG, response.body().toString())
//                    val toast =Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<PostMovies>, t: Throwable) {
                    Log.e(ContentValues.TAG, "onFailure: ${t.message}")
                }

            })
            val context=holder.itemView.context
            val intent = Intent( context, MoviesActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return this.data.size
    }
}