package com.example.lab7_retrofit.ui.categories.repository

import com.example.lab7_retrofit.database.categories.MealCategoryDao
import com.example.lab7_retrofit.networking.MealsWebService
import com.example.lab7_retrofit.networking.response.categories.categories
import com.example.lab7_retrofit.networking.response.categories.toEntity
import com.example.lab7_retrofit.networking.response.categories.categoriesResponse
import com.example.lab7_retrofit.database.categories.MealCategoryEntity
import com.example.lab7_retrofit.networking.webservices.IMealsWebService



class categoriesRepository(private val webService: IMealsWebService,
                              private val mealCategoryDao: MealCategoryDao
) {
    suspend fun getMealsCategories(): List<MealCategoryEntity> {
        val entities = webService.getMealsCategories().categories
        val content = entities.map { it.toEntity() }
        mealCategoryDao.insertAll(content)
        return mealCategoryDao.getAllMealCategories()
    }
}