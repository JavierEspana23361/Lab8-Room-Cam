package com.example.lab7_retrofit.networking.webservices

import com.example.lab7_retrofit.networking.response.MealsApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.lab7_retrofit.networking.response.categories.categoriesResponse
import com.example.lab7_retrofit.networking.response.meals.mealsResponse

interface IMealsWebService {
    suspend fun getMealsCategories(): categoriesResponse
    suspend fun filterMealsByCategory(category: String): mealsResponse
}

class MealsWebService: IMealsWebService {

    private var api: MealsApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealsApi::class.java)
    }

    override suspend fun getMealsCategories(): categoriesResponse {
        return api.getcategories()
    }

    override suspend fun filterMealsByCategory(category: String): mealsResponse {
        return api.filtercategories(category)
    }
}