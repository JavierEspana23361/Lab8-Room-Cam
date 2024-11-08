package com.example.lab7_retrofit.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lab7_retrofit.database.categories.MealCategoryDao
import com.example.lab7_retrofit.database.categories.MealCategoryEntity

@Database(entities = [MealCategoryEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun mealCategoryDao(): MealCategoryDao
}