package com.example.lab7_retrofit.ui.mealdetail.repository

import com.example.lab7_retrofit.networking.MealsWebService
import com.example.lab7_retrofit.networking.response.mealdetail.mealdetailResponse

class mealdetailRepository(private val webService: MealsWebService = MealsWebService()) {

    suspend fun getmealdetail(mealId: String): mealdetailResponse {
        return webService.getmealdetail(mealId)
    }
}