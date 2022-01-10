package com.example.mwsteorimovieandfood.pages

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mwsteorimovieandfood.R
import com.example.mwsteorimovieandfood.api.ApiConfig
import com.example.mwsteorimovieandfood.api.response.bioskop.DataItem
import com.example.mwsteorimovieandfood.api.response.bioskop.GetBioskop
import com.example.mwsteorimovieandfood.api.response.bioskop.PostBioskop
import com.example.mwsteorimovieandfood.pages.bioskop.AddBioskopMainActivity.Companion.TAG
import com.example.mwsteorimovieandfood.pages.bioskop.LocationBioskopActivity
import com.example.mwsteorimovieandfood.pages.bioskop.UpdateBioskopActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BioskopAdapter : RecyclerView.Adapter<BioskopAdapter.ViewHolder>(){

    private var data: ArrayList<DataItem> = arrayListOf()

    fun setData(data: List<DataItem>){
        this.data.clear()
        this.data.addAll(data)
        this.notifyDataSetChanged()
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvTitleBioskop= itemView.findViewById<TextView>(R.id.tvTitleBioskop)
        val tvStatus = itemView.findViewById<TextView>(R.id.tvStatus)
        val tvAlamat = itemView.findViewById<TextView>(R.id.tvAlamatBioskop)
        val btnUpdateBioskop = itemView.findViewById<ImageButton>(R.id.btnUpdateBioskop)
        val btnDeleteBioskop = itemView.findViewById<ImageButton>(R.id.btndeleteBioskop)
        val tvIdBioskop = itemView.findViewById<TextView>(R.id.TvIdBioskop)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BioskopAdapter.ViewHolder {
       return ViewHolder(LayoutInflater
           .from(parent.context)
           .inflate(R.layout.items_list_bioskop, parent, false)
       )
    }

    override fun onBindViewHolder(holder: BioskopAdapter.ViewHolder, position: Int) {
        val itemData = data[position]
        holder.tvTitleBioskop.text=itemData.nama
        holder.tvStatus.text = itemData.status
        holder.tvAlamat.text = itemData.alamat
        holder.tvIdBioskop.text = itemData.id

        holder.btnUpdateBioskop.setOnClickListener {
            val context=holder.itemView.context
            val intent = Intent( context, UpdateBioskopActivity::class.java)
            intent.putExtra("Key_Id", holder.tvIdBioskop.text)
            intent.putExtra("Key_NamaBioskop", holder.tvTitleBioskop.text).toString()
//            intent.putExtra("Key_StatusBioskop", holder.tvStatus.text)
            intent.putExtra("Key_AlamatBioskop", holder.tvAlamat.text).toString()
//            intent.putExtra("Key_Kampus", holder.tvProdi.isSelected)
//            intent.putExtra("Key_Gender", holder.tvJenisKelamin.text)
            context.startActivity(intent)


        }
        //        Action on button delete
        holder.btnDeleteBioskop.setOnClickListener {
            val id = holder.tvIdBioskop.text.toString().toInt()
            ApiConfig.getService().deleteBioskop(id = id).enqueue(object :
                Callback<PostBioskop> {
                override fun onResponse(
                    call: Call<PostBioskop>,
                    response: Response<PostBioskop>
                ) {
                    Log.e(TAG, response.body().toString())
//                    val toast =Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<PostBioskop>, t: Throwable) {
                    Log.e(TAG, "onFailure: ${t.message}")
                }

            })
            val context=holder.itemView.context
            val intent = Intent( context, LocationBioskopActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return this.data.size
    }

}