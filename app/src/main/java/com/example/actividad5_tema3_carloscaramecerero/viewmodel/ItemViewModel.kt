package com.example.actividad5_tema3_carloscaramecerero.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.actividad5_tema3_carloscaramecerero.model.Item
import com.example.actividad5_tema3_carloscaramecerero.repository.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val repository: ItemRepository
) : ViewModel() {

    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val items: StateFlow<List<Item>> get() = _items

    // Cargar items desde el backend
    fun loadItems() {
        viewModelScope.launch {
            try {
                _items.value = repository.getItems()
            } catch (e: Exception) {
                // Manejar error, por ejemplo log o mostrar mensaje
                e.printStackTrace()
            }
        }
    }

    // Agregar item
    fun addItem(item: Item) {
        viewModelScope.launch {
            try {
                val newItem = repository.addItem(item)
                _items.value = _items.value + newItem
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    // Actualizar item
    fun updateItem(item: Item) {
        viewModelScope.launch {
            try {
                val updated = repository.updateItem(item)
                _items.value = _items.value.map { if (it.id == updated.id) updated else it }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    // Eliminar item
    fun deleteItem(id: Long) {
        viewModelScope.launch {
            try {
                repository.deleteItem(id)
                _items.value = _items.value.filter { it.id != id }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
