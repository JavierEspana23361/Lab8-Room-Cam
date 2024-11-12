package com.example.lab7_retrofit.networking.response.categories

import com.google.gson.annotations.SerializedName

data class categories(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val name: String?,
    @SerializedName("strCategoryDescription") val description: String,
    @SerializedName("strCategoryThumb") val imageUrl: String
)

