package com.example.mwsteorimovieandfood.pages

import android.content.ContentValues.TAG
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
import com.example.mwsteorimovieandfood.api.response.food.DataItem
import com.example.mwsteorimovieandfood.api.response.food.PostFood
import com.example.mwsteorimovieandfood.pages.food.ListFoodsMainActivity
import com.example.mwsteorimovieandfood.pages.food.UpdateFoodsMainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodAdapter : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {
    private var data: ArrayList<DataItem> = arrayListOf()

    fun setData(data: List<DataItem>){
        this.data.clear()
        this.data.addAll(data)
        this.notifyDataSetChanged()
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvTitleMakanan= itemView.findViewById<TextView>(R.id.tvTitleMakanan)
        val tvStatusMakanan = itemView.findViewById<TextView>(R.id.tvStatusMakanan)
        val tvHarga = itemView.findViewById<TextView>(R.id.tvHargaMakanan)
        val btnUpdateMakanan = itemView.findViewById<ImageButton>(R.id.btnUpdateMakanan)
        val btnDeleteMakanan = itemView.findViewById<ImageButton>(R.id.btndeleteMakanan)
        val tvIdMakanan = itemView.findViewById<TextView>(R.id.TvIdMakanan)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater
            .from(parent.context)
            .inflate(R.layout.items_list_food, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemData = data[position]
        holder.tvTitleMakanan.text=itemData.nama
        holder.tvStatusMakanan.text = itemData.status
        holder.tvHarga.text = itemData.harga
        holder.tvIdMakanan.text = itemData.id

        holder.btnUpdateMakanan.setOnClickListener {
            val context=holder.itemView.context
            val intent = Intent( context, UpdateFoodsMainActivity::class.java)
            intent.putExtra("Key_IdMakanan", holder.tvIdMakanan.text)
            intent.putExtra("Key_NamaMakanan", holder.tvTitleMakanan.text).toString()
//            intent.putExtra("Key_StatusBioskop", holder.tvStatus.text)
            intent.putExtra("Key_HargaMakanan", holder.tvHarga.text)
//            intent.putExtra("Key_Kampus", holder.tvProdi.isSelected)
//            intent.putExtra("Key_Gender", holder.tvJenisKelamin.text)
            context.startActivity(intent)


        }
        //        Action on button delete
        holder.btnDeleteMakanan.setOnClickListener {
            val id = holder.tvIdMakanan.text.toString().toInt()
            ApiConfig.getService().deleteMakanan(id = id).enqueue(object :
                Callback<PostFood> {
                override fun onResponse(
                    call: Call<PostFood>,
                    response: Response<PostFood>
                ) {
                    Log.e(TAG, response.body().toString())
//                    val toast =Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<PostFood>, t: Throwable) {
                    Log.e(TAG, "onFailure: ${t.message}")
                }

            })
            val context=holder.itemView.context
            val intent = Intent( context, ListFoodsMainActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return this.data.size
    }

}