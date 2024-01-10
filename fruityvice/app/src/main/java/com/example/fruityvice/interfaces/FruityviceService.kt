package com.example.fruityvice.interfaces

import com.example.fruityvice.model.Fruit
import retrofit2.http.GET

interface FruityviceService {
   @GET("/api/fruit/all")
   suspend fun listAllFruits() : List<Fruit>
}