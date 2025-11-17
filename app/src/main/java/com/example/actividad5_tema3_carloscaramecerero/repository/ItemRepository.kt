package com.example.actividad5_tema3_carloscaramecerero.repository

import com.example.actividad5_tema3_carloscaramecerero.api.ApiService
import com.example.actividad5_tema3_carloscaramecerero.model.Item
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ItemRepository @Inject constructor(private val api: ApiService) {
    suspend fun getItems() = api.getItems()
    suspend fun addItem(item: Item) = api.addItem(item)
    suspend fun updateItem(item: Item) = api.updateItem(item.id, item)
    suspend fun deleteItem(id: Long) = api.deleteItem(id)
}
