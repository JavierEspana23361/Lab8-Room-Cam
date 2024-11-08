package com.example.lab7_retrofit.database.categories

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MealCategoryDao {

    @Query("SELECT * FROM meal_categories")
    suspend fun getAllMealCategories(): List<MealCategoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(mealCategories: List<MealCategoryEntity>)


}