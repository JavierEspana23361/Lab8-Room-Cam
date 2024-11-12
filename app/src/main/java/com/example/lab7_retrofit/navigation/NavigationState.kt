package com.example.lab7_retrofit.navigation

sealed class NavigationState(val route: String) {
    object MealsCategories : NavigationState("categories")

    object MealsRecipesList : NavigationState("categories/{category}") {
        fun createRoute(category: String) = "categories/$category"
    }

    object MealDetail : NavigationState("mealDetail/{mealId}") {
        fun createRoute(mealId: String) = "mealDetail/$mealId"
    }

    object Home : NavigationState("home")
    object Profile : NavigationState("profile")
}