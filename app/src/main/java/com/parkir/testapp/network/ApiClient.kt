package com.dicoding.hitungcepat.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object{
        val BASE_URL:String = "https://www.themealdb.com/api/json/v1/1/"
        var retrofit:Retrofit ?= null

        @JvmName("getRetrofit1")
        fun getRetrofit() : Retrofit? {
            if (retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
        fun getService() = getRetrofit()?.create(ApiService::class.java)
    }
}