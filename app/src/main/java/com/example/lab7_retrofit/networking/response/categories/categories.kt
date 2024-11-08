package com.example.lab7_retrofit.networking.response.categories

import com.google.gson.annotations.SerializedName
import com.example.lab7_retrofit.database.categories.MealCategoryEntity

data class categories(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val name: String?,
    @SerializedName("strCategoryDescription") val description: String,
    @SerializedName("strCategoryThumb") val imageUrl: String
)
fun categories.toEntity(): MealCategoryEntity {
    return MealCategoryEntity(
        id = this.id,
        name = this.name ?: "",
        imageUrl = this.imageUrl,
        description = this.description
    )
}

