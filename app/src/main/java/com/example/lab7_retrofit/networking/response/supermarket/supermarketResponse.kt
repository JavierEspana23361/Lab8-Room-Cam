package com.example.lab7_retrofit.networking.response.supermarket

import com.example.lab7_retrofit.networking.response.mealdetail.supermarket
import com.google.gson.annotations.SerializedName

data class supermarketResponse(
    @SerializedName("meals") val meals: List<supermarket>
)