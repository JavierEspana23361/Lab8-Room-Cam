package com.example.lab7_retrofit.networking.response.mealdetail

import com.google.gson.annotations.SerializedName

data class supermarket(
    @SerializedName("idMeal") val id: String,
    @SerializedName("strMeal") val name: String,
    @SerializedName("strMealThumb") val imageUrl: String,
)


