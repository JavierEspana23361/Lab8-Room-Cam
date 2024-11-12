package com.example.lab7_retrofit.ui.supermarket.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

data class SupermarketItem(val name: String, val quantity: Int)

class SupermarketRepository {

    private val _items = MutableStateFlow<List<SupermarketItem>>(emptyList())
    val allItems: Flow<List<SupermarketItem>> = _items.asStateFlow()

    fun insert(item: SupermarketItem) {
        _items.value = _items.value + item
    }

    fun delete(item: SupermarketItem) {
        _items.value = _items.value - item
    }
}