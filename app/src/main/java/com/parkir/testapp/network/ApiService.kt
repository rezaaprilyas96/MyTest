package com.dicoding.hitungcepat.network

import com.parkir.testapp.model.ListResep
import com.parkir.testapp.model.categori
import retrofit2.Call
import retrofit2.http.*


interface ApiService {
    @GET("categories.php")
    fun getListResep(): Call<categori>
}