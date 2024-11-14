// SupermarketRepository.kt
package com.example.lab7_retrofit.ui.supermarket.repository

import com.example.lab7_retrofit.database.supermarket.SupermarketItemDao
import com.example.lab7_retrofit.database.supermarket.SupermarketItemEntity
import com.example.lab7_retrofit.networking.MealsWebService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SupermarketRepository(
    private val webService: MealsWebService,
    private val dao: SupermarketItemDao
) {

    private val _items = MutableStateFlow<List<SupermarketItemEntity>>(emptyList())
    val allItems: Flow<List<SupermarketItemEntity>> = _items.asStateFlow()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            _items.value = dao.getAllItems().first()
        }
    }

    suspend fun insertItem(item: SupermarketItemEntity) {
        withContext(Dispatchers.IO) {
            dao.insert(item)
            _items.value = dao.getAllItems().first()
        }
    }

    suspend fun deleteItem(itemId: String) {
        withContext(Dispatchers.IO) {
            dao.delete(SupermarketItemEntity(id = itemId.toInt(), name = "", quantity = "", imagePath = null))
            _items.value = dao.getAllItems().first()
        }
    }

    suspend fun getmealdetail(mealId: String) = webService.getmealdetail(mealId)

    suspend fun getAllItems(): List<SupermarketItemEntity> = withContext(Dispatchers.IO) {
        dao.getAllItems().first()
    }
}