package com.example.lab7_retrofit.networking.response.meals

import com.google.gson.annotations.SerializedName

data class mealsResponse(
    @SerializedName("meals") val meals: List<meals>
)