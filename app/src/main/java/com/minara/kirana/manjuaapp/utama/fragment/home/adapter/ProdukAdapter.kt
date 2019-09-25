package com.minara.kirana.manjuaapp.utama.fragment.home.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.minara.kirana.manjuaapp.R
import com.minara.kirana.manjuaapp.utama.fragment.home.data.KategoriItem
import kotlinx.android.synthetic.main.item_product.view.*

class ProdukAdapter(var data: List<KategoriItem?>?): RecyclerView.Adapter<ProdukAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount():Int {
        return  data?.size ?: 0
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(data?.get(position))
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(get:KategoriItem?){
            itemView.produktitle.text = get?.kategoriNama

            Glide.with(itemView.context).load("http://192.168.43.124/server_commerce/image_growback/"+get?.foto)
                .into(itemView.produkgambar)
        }
    }
}