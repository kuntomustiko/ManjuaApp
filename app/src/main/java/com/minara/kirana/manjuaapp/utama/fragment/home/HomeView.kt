package com.minara.kirana.manjuaapp.utama.fragment.home

import com.minara.kirana.manjuaapp.utama.fragment.home.data.KategoriItem
import com.minara.kirana.manjuaapp.utama.fragment.home.data.ProdukItem

interface HomeView {

    fun onSuccessProduk(data:List<ProdukItem?>?)
    fun onErrorProduk(msg:String?)

    fun onSuccessKategori(data: List<KategoriItem?>?)
    fun onErrorKategori(msg: String?)
}