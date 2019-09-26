package com.minara.kirana.manjuaapp.network

import com.minara.kirana.manjuaapp.utama.fragment.home.data.ResultProduk
import com.minara.kirana.manjuaapp.login.data.ResultLogin
import com.minara.kirana.manjuaapp.register.data.ResultRegister
import com.minara.kirana.manjuaapp.utama.fragment.home.data.ResultKategori
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ManjuaService {

    // bikin ini sesuai dengan registerCustomer dan hal-hal apa saja yang dibutuhkan ketika registerCustomer
    @FormUrlEncoded
    @POST("registerCustomer")
    fun register(
        @Field("nama") nama: String,
        @Field("email") email: String,
        @Field("hp") hp: String,
        @Field("password") password: String
    ): Call<ResultRegister>


    // bikin ini sesuai dengan loginCustomer dan hal-hal apa saja yang dibutuhkan ketika loginCustomer
    @FormUrlEncoded
    @POST("loginCustomer")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<ResultLogin>

    // bikin ini sesuai dengan loginGmail dan hal-hal apa saja yang dibutuhkan ketika loginGmail
    @FormUrlEncoded
    @POST("loginGmail")
    fun loginGmail(
        @Field("email") email: String,
        @Field("name") name: String
    ): Call<ResultLogin>

    // bikin ini sesuai dengan updateHpUser dan hal-hal apa saja yang dibutuhkan ketika updateHpUser
    @FormUrlEncoded
    @POST("updateHpUser")
    fun verify(
        @Field("idUser") idUser: String,
        @Field("hp") hp: String
    ): Call<ResultRegister>


    // hari ke 3
    // bikin ini untuk mendapatkan data dengan get dari get produk
    @GET("getProduk")
    fun getProduk(): Call<ResultProduk>

    @GET("getKategori")
    fun getKategori(): Call<ResultKategori>

    @GET("populer")
    fun getPopuler(): Call<ResultProduk>

    @GET("promosi")
    fun getPromosi(): Call<ResultProduk>

    @FormUrlEncoded
    @POST("produkPerKategori")
    fun getProdukKategori(@Field("id")id:String): Call<ResultProduk>
}