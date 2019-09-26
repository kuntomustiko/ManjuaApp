package com.minara.kirana.manjuaapp.listProduk

import com.minara.kirana.manjuaapp.network.NetworkConfig
import com.minara.kirana.manjuaapp.utama.fragment.home.data.ResultProduk
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProdukPresenter(val produkView: ProdukView) {

    fun getPromot(){
        NetworkConfig.service().getPromosi()
            .enqueue(object : Callback<ResultProduk>{
                override fun onFailure(call: Call<ResultProduk>, t: Throwable) {
               produkView.onErrorProduk(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultProduk>,
                    response: Response<ResultProduk>
                ) {
                    if (response.body()?.status == 200){
                        produkView.onSuccessProduk(response.body()?.kategori)
                    } else{
                        produkView.onErrorProduk(response.body()?.message)
                    }
                }

            })
    }

    fun getPopuler(){
        NetworkConfig.service().getPopuler()
            .enqueue(object : Callback<ResultProduk>{
                override fun onFailure(call: Call<ResultProduk>, t: Throwable) {
                    produkView.onErrorProduk(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultProduk>,
                    response: Response<ResultProduk>
                ) {
                    if (response.body()?.status == 200){
                        produkView.onSuccessProduk(response.body()?.kategori)
                    } else{
                        produkView.onErrorProduk(response.body()?.message)
                    }
                }

            })
    }

    fun getProdukKategori(id:String){
        NetworkConfig.service().getProdukKategori(id)
            .enqueue(object : Callback<ResultProduk>{
                override fun onFailure(call: Call<ResultProduk>, t: Throwable) {
                    produkView.onErrorProduk(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultProduk>,
                    response: Response<ResultProduk>
                ) {
                    if (response.body()?.status == 200){
                        produkView.onSuccessProduk(response.body()?.kategori)
                    } else{
                        produkView.onErrorProduk(response.body()?.message)
                    }
                }

            })
    }
}