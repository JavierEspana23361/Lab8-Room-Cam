package com.example.lab7_retrofit.networking.response

import com.example.lab7_retrofit.networking.response.categories.categoriesResponse
import com.example.lab7_retrofit.networking.response.meals.mealsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApi {

    @GET("categories.php")
    suspend fun getcategories(): categoriesResponse


    @GET("filter.php")
    suspend fun filtercategories(
        @Query("c") category: String
    ): mealsResponse


    @GET("lookup.php")
    fun <mealdetailResponse : Any?> getmealdetail(
        @Query("i") mealId: String
    ): Call<mealdetailResponse>
}
