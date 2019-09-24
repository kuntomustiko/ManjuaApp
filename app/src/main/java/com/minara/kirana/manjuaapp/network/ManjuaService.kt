package com.minara.kirana.manjuaapp.network

import com.minara.kirana.manjuaapp.login.data.ResultLogin
import com.minara.kirana.manjuaapp.register.data.ResultRegister
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ManjuaService {

    // bikin ini sesuai dengan registerCustomer dan hal-hal apa saja yang dibutuhkan ketika registerCustomer
    @FormUrlEncoded
    @POST("registerCustomer")
    fun register(
        @Field("nama") nama: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("hp") hp: String
    ): Call<ResultRegister>


    // bikin ini sesuai dengan loginCustomer dan hal-hal apa saja yang dibutuhkan ketika loginCustomer
    @FormUrlEncoded
    @POST("loginCustomer")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<ResultLogin>

    // bikin ini sesuai dengan loginCustomer dan hal-hal apa saja yang dibutuhkan ketika loginGmail
    @FormUrlEncoded
    @POST("loginCustomer")
    fun loginGmail(
        @Field("email") email: String,
        @Field("name") name: String
    ): Call<ResultLogin>

}