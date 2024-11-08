package com.example.lab7_retrofit

import android.app.Application
import androidx.room.Room
import com.example.lab7_retrofit.database.AppDatabase
import com.example.lab7_retrofit.ui.categories.repository.categoriesRepository
import com.example.lab7_retrofit.networking.MealsWebService


class MealsApp : Application() {

    // Singleton instance of the Room database
    private lateinit var database: AppDatabase
        private set

    lateinit var categoryRepository: categoriesRepository
        private set

    lateinit var categoryWebService: MealsWebService
        private set

    override fun onCreate() {
        super.onCreate()

        categoryWebService = MealsWebService()
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "meal-categories-db"
        ).build()

        categoryRepository = categoriesRepository(
            categoryWebService,
            database.mealCategoryDao()
        )
    }
}