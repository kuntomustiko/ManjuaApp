package com.minara.kirana.manjuaapp.verifyHp

import com.minara.kirana.manjuaapp.network.NetworkConfig
import com.minara.kirana.manjuaapp.register.data.ResultRegister
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VerifyPresenter(val verifyView: VerifyView) {

    fun verifyHp(hp: String, idUser: String) {
        NetworkConfig.service()
            .verify(idUser, hp)
            .enqueue(object : Callback<ResultRegister> {
                override fun onFailure(call: Call<ResultRegister>, t: Throwable) {

                    verifyView.onError(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultRegister>,
                    response: Response<ResultRegister>
                ) {
                    if (response.isSuccessful) {
                        if (response.body()?.status == 200) {
                            verifyView.onSuccessUpdate(response.body()?.message)
                        } else {
                            verifyView.onError(response.body()?.message)
                        }

                    }
                }

            })
    }
}