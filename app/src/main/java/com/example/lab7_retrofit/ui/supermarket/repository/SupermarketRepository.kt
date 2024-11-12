package com.example.lab7_retrofit.ui.supermarket.repository

import com.example.lab7_retrofit.networking.MealsWebService
import com.example.lab7_retrofit.networking.response.mealdetail.mealdetailResponse
import com.example.lab7_retrofit.networking.response.supermarket.supermarketResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

data class SupermarketItem(val name: String, val quantity: Int)

class SupermarketRepository(private val webService: MealsWebService = MealsWebService()) {

    private val _items = MutableStateFlow<List<SupermarketItem>>(emptyList())
    val allItems: Flow<List<SupermarketItem>> = _items.asStateFlow()

    private val mealIds = mutableListOf<String>()

    suspend fun fetchItems(mealId: String): supermarketResponse {
        return webService.fetchItems(mealId)
    }

    fun insert(mealId: String) {
        mealIds.add(mealId)
    }

    fun delete(mealId: String) {
        mealIds.remove(mealId)
    }
}