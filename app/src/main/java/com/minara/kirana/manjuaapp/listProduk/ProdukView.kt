package com.minara.kirana.manjuaapp.listProduk

import com.minara.kirana.manjuaapp.utama.fragment.home.data.ProdukItem

interface ProdukView {

    fun onSuccessProduk(data: List<ProdukItem?>?)
    fun onErrorProduk(msg:String?)
}