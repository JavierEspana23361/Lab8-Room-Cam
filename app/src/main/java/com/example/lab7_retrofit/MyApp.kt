// MyApp.kt
package com.example.lab7_retrofit

import android.app.Application
import android.util.Log
import androidx.room.Room
import com.example.lab7_retrofit.database.AppDatabase
import com.example.lab7_retrofit.database.supermarket.SupermarketItemEntity
import com.example.lab7_retrofit.ui.supermarket.repository.SupermarketRepository
import com.example.lab7_retrofit.networking.MealsWebService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MyApp : Application() {
    lateinit var database: AppDatabase
    lateinit var repository: SupermarketRepository

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "supermarket-database"
        ).build()
        repository = SupermarketRepository(MealsWebService(), database.supermarketItemDao())
    }

    fun addItem(mealId: String) {
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            try {
                val response = repository.getmealdetail(mealId)
                val meal = response.meals.firstOrNull()
                if (meal != null) {
                    val existingItems = repository.getAllItems()
                    val itemExists = existingItems.any { item -> item.name == meal.name }
                    if (!itemExists) {
                        val item = SupermarketItemEntity(
                            name = meal.name,
                            quantity = "1",
                            imagePath = meal.imageUrl
                        )
                        repository.insertItem(item)
                    }
                }
            } catch (e: HttpException) {
                Log.e("SupermarketViewModel", "HTTP error: ${e.message()}")
            } catch (e: Exception) {
                Log.e("SupermarketViewModel", "Error: ${e.message}")
            }
        }
    }
}