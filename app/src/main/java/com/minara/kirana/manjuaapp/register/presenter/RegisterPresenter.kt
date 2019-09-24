package com.minara.kirana.manjuaapp.register.presenter

import android.util.Log
import com.minara.kirana.manjuaapp.network.NetworkConfig
import com.minara.kirana.manjuaapp.register.data.ResultRegister
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter(val registerView: RegisterView) {

    // membuat fun yang memiliki 4 parameter sesuai dengan data yang ada di register Activity
    fun register(nama:String, email:String, hp:String, password:String){
        NetworkConfig.service().register(nama, email,hp, password)
            .enqueue(object :Callback<ResultRegister>{
                override fun onFailure(call: Call<ResultRegister>, t: Throwable) {
                    registerView.onError(t.localizedMessage)

                }

                override fun onResponse(
                    call: Call<ResultRegister>,
                    response: Response<ResultRegister>
                ) {

                    if (response.body()?.status == 200){
                        registerView.onSuccessRegister(response.body()?.message)
                    } else{
                        registerView.onError(response.body()?.message)

                    }
                }

            })
    }
}