package com.minara.kirana.manjuaapp.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkConfig {

    fun getInterceptor(): OkHttpClient {


        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient().newBuilder()
            .addInterceptor(interceptor)
            .build()
    }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.43.124/server_commerce/index.php/Api/")
            .client(getInterceptor())

            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun service()= getRetrofit().create(ManjuaService::class.java)
}