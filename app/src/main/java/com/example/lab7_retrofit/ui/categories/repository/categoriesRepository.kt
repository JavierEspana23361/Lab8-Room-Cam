package com.example.lab7_retrofit.ui.categories.repository

import com.example.lab7_retrofit.networking.MealsWebService
import com.example.lab7_retrofit.networking.response.categories.categories


class categoriesRepository(private val webService: MealsWebService = MealsWebService()) {

    suspend fun getcategories(): List<categories> {
        return webService.getcategories().categories
    }
}