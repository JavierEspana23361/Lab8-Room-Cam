package com.example.lab7_retrofit.networking

import com.example.lab7_retrofit.networking.response.MealsApi
import com.example.lab7_retrofit.networking.response.categories.categoriesResponse
import com.example.lab7_retrofit.networking.response.mealdetail.mealdetailResponse
import com.example.lab7_retrofit.networking.response.meals.mealsResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MealsWebService {

    private var api: MealsApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealsApi::class.java)
    }

    suspend fun getcategories(): categoriesResponse {
        return api.getcategories()
    }

    suspend fun filtercategory(category: String): mealsResponse {
        return api.filtercategories(category)
    }

    fun getmealdetail(mealId: String): Call<mealdetailResponse> {
        return api.getmealdetail(mealId)
    }

}
