package com.example.lab7_retrofit.networking.response.mealdetail

import com.google.gson.annotations.SerializedName

data class mealdetailResponse(
    @SerializedName("meals") val meals: List<mealdetail>
)