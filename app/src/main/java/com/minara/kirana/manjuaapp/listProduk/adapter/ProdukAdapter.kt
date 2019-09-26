package com.minara.kirana.manjuaapp.listProduk.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.minara.kirana.manjuaapp.R
import com.minara.kirana.manjuaapp.utama.fragment.home.data.ProdukItem
import kotlinx.android.synthetic.main.item_produk.view.*

class ProdukAdapter(var data: List<ProdukItem?>?) : RecyclerView.Adapter<ProdukAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_produk, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount() = data?.size ?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(data?.get(position))
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(get: ProdukItem?) {
            itemView.produkRating.rating = get?.produkRating?.toFloat() ?: 0f
            itemView.produkTitle.text = get?.produkNama
            itemView.produkHarga.text = "Rp. " + get?.produkHarga

            Glide.with(itemView.context)
                .load("http://192.168.43.124/server_commerce/image_growback/" + get?.produkGambar)
                .into(itemView.produkImg)

        }
    }
}