package com.example.fruityvice.services

import com.example.fruityvice.interfaces.FruityviceService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://www.fruityvice.com/"
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL).build()
    }
}

object ApiClient {
    val fruityviceService: FruityviceService by lazy {
        RetrofitClient.retrofit.create(FruityviceService::class.java)
    }
}