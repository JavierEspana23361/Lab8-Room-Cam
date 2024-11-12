package com.example.lab7_retrofit.ui.meals.repository

import com.example.lab7_retrofit.networking.MealsWebService
import com.example.lab7_retrofit.networking.response.meals.meals

class mealsRepository (private val webService: MealsWebService = MealsWebService()) {
    suspend fun filtercategory(category: String): List<meals> {
        return webService.filtercategory(category).meals
    }
}