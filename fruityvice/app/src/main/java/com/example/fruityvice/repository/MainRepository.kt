package com.example.fruityvice.repository

import com.example.fruityvice.interfaces.FruityviceService
import com.example.fruityvice.model.Fruit
import com.example.fruityvice.services.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject


class MainRepository @Inject constructor(private val fruityviceService: FruityviceService){

    suspend fun getFruits(): List<Fruit> {
        return withContext(Dispatchers.IO) {
            try {
                fruityviceService.listAllFruits()
            } catch (e: HttpException) {
                emptyList()
            } catch (e: Exception) {
                emptyList()
            }
        }

    }
}