package com.example.mwsteorimovieandfood.pages

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mwsteorimovieandfood.R
import com.example.mwsteorimovieandfood.api.response.bioskop.DataItem
import com.example.mwsteorimovieandfood.model.BioskopModel

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BioskopAdapter (    private var data: ArrayList<BioskopModel> = arrayListOf()) :
    RecyclerView.Adapter<BioskopAdapter.ViewHolder>(){

//    private var data: ArrayList<BioskopModel> = arrayListOf()

//    fun setData(data: List<BioskopModel>){
//        this.data.clear()
//        this.data.addAll(data)
//        this.notifyDataSetChanged()
//    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvTitleBioskop= itemView.findViewById<TextView>(R.id.tvTitleBioskop)
        val tvStatus = itemView.findViewById<TextView>(R.id.tvStatus)
        val tvAlamat = itemView.findViewById<TextView>(R.id.tvAlamat)
//        val btnupdate = itemView.findViewById<Button>(R.id.btnUpdateBioskop)
//        val btndelete = itemView.findViewById<Button>(R.id.btnDeleteBioskop)

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

//        holder.btnupdate.setOnClickListener {
//            val context=holder.itemView.context
//            val intent = Intent( context, UpdateDataActivity::class.java)
//            intent.putExtra("Key_Id", holder.tvID.text.toString().toInt())
//            intent.putExtra("Key_Nim", holder.tvNim.text.toString())
//            intent.putExtra("Key_Nama", holder.tvName.text.toString())
////            intent.putExtra("Key_Kampus", holder.tvProdi.isSelected)
////            intent.putExtra("Key_Gender", holder.tvJenisKelamin.text)
//            context.startActivity(intent)
//        }
//        holder.btndelete.setOnClickListener {
//            val nim = holder.tvNim.text.toString()
//            ApiConfig.getService().deleteWebinar(nim = nim).enqueue(object :
//                Callback<ParticipantResponse> {
//                override fun onResponse(
//                    call: Call<ParticipantResponse>,
//                    response: Response<ParticipantResponse>
//                ) {
//                    Log.e(TAG, response.body().toString())
////                    val toast =Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
//                }
//
//                override fun onFailure(call: Call<ParticipantResponse>, t: Throwable) {
//                    Log.e(TAG, "onFailure: ${t.message}")
//                }
//
//            })
//            val context=holder.itemView.context
//            val intent = Intent( context, MainActivity::class.java)
//            context.startActivity(intent)
//        }
    }

    override fun getItemCount(): Int {
        return this.data.size
    }
}