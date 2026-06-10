package com.utama.a1_mo
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("getBarang.php")
    fun getBarang(): Call<List<Barang>>

}