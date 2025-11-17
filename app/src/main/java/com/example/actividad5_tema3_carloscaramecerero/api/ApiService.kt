package com.example.actividad5_tema3_carloscaramecerero.api

import com.example.actividad5_tema3_carloscaramecerero.model.Item
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("items")
    suspend fun getItems(): List<Item>

    @POST("items")
    suspend fun addItem(@Body item: Item): Item

    @PUT("items/{id}")
    suspend fun updateItem(@Path("id") id: Long, @Body item: Item): Item

    @DELETE("items/{id}")
    suspend fun deleteItem(@Path("id") id: Long): Response<Unit>
}
