package com.example.lab7_retrofit.ui.mealdetail.repository

import com.example.lab7_retrofit.networking.MealsWebService
import com.example.lab7_retrofit.networking.response.mealdetail.mealdetailResponse
import retrofit2.Call


class mealdetailRepository(private val webService: MealsWebService = MealsWebService()) {

    suspend fun getmealdetail(mealId: String): Call<mealdetailResponse> {
        return webService.getmealdetail(mealId)
    }
}
