package com.minara.kirana.manjuaapp.utama.fragment.home

import com.minara.kirana.manjuaapp.network.NetworkConfig
import com.minara.kirana.manjuaapp.utama.fragment.home.data.ResultKategori
import com.minara.kirana.manjuaapp.utama.fragment.home.data.ResultProduk
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter (var homeView: HomeView) {

    fun getProduk(){
        NetworkConfig.service()
            .getProduk()
            .enqueue(object : Callback<ResultProduk>{
                override fun onFailure(call: Call<ResultProduk>, t: Throwable) {
                    homeView.onErrorProduk(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultProduk>,
                    response: Response<ResultProduk>
                ) {
                    if (response.body()?.status == 200){
                        homeView.onSuccessProduk(response.body()?.kategori)
                    }
                }
            })
    }

    fun getKategori(){
        NetworkConfig.service().getKategori()
            .enqueue(object : Callback<ResultKategori>{
                override fun onFailure(call: Call<ResultKategori>, t: Throwable) {
                    homeView.onErrorKategori(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultKategori>,
                    response: Response<ResultKategori>
                ) {
                    if (response.body()?.status == 200){
                        homeView.onSuccessKategori(response.body()?.kategori)
                    }
                }

            })
    }
}