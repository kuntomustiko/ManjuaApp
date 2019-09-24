package com.minara.kirana.manjuaapp.login.presenter

import com.minara.kirana.manjuaapp.login.data.ResultLogin
import com.minara.kirana.manjuaapp.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter (val loginView: LoginView) {

    fun login(email:String, password:String){
        if (email.isEmpty()){
            loginView.onError("email tidak boleh kosong")
        } else if (password.isEmpty()){
            loginView.onError("password tidak boleh kosong")
        } else{
        NetworkConfig.service()
            .login(email, password)
            .enqueue(object : Callback<ResultLogin>{
                override fun onFailure(call: Call<ResultLogin>, t: Throwable) {
                    loginView.onError(t.localizedMessage)
                }

                override fun onResponse(call: Call<ResultLogin>, response: Response<ResultLogin>) {
                    if (response.body()?.status == 200){
                        loginView.onSuccessLogin(response.body()?.user, response.body()?.message)
                    } else{
                        loginView.onError(response.body()?.message)
                    }
                }

            })

        }
    }

    fun loginGmail(email:String, name:String){
        NetworkConfig.service()
            .loginGmail(email, name)
            .enqueue(object : Callback<ResultLogin>{
                override fun onFailure(call: Call<ResultLogin>, t: Throwable) {
                    loginView.onError(t.localizedMessage)
                }

                override fun onResponse(call: Call<ResultLogin>, response: Response<ResultLogin>) {
                    if (response.body()?.status == 200){
                        loginView.onSuccessLoginGmail(response.body()?.user, response.body()?.message, response.body()?.user_id)
                    } else{
                        loginView.onError(response.body()?.message)
                    }
                }

            })
    }


}