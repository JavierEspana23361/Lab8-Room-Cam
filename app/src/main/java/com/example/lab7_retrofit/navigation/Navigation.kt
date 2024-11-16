// Navigation.kt
package com.example.lab7_retrofit.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.lab7_retrofit.ui.camera.view.CameraScreen
import com.example.lab7_retrofit.ui.categories.view.MealsCategoriesScreen
import com.example.lab7_retrofit.ui.mealdetail.view.MealsDetailScreen
import com.example.lab7_retrofit.ui.meals.view.MealsFilterScreen
import com.example.lab7_retrofit.ui.supermarket.view.SupermarketScreen

@Composable
fun Navigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = NavigationState.MealsCategories.route,
        modifier = modifier
    ) {
        composable(route = NavigationState.MealsCategories.route) {
            MealsCategoriesScreen(navController = navController)
        }
        composable(
            route = NavigationState.MealsRecipesList.route,
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val categoryName = backStackEntry.arguments?.getString("category") ?: ""
            MealsFilterScreen(navController = navController, category = categoryName)
        }
        composable(
            route = NavigationState.MealDetail.route,
            arguments = listOf(navArgument("mealId") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val mealId = backStackEntry.arguments?.getString("mealId") ?: ""
            MealsDetailScreen(navController = navController, mealId = mealId)
        }
        composable(route = "supermarket") {
            SupermarketScreen(navController = navController)
        }
        composable(
            route = "camera_screen/{mealName}",
            arguments = listOf(navArgument("mealName") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val mealName = backStackEntry.arguments?.getString("mealName") ?: ""
            CameraScreen(navController = navController, mealName = mealName)
        }
    }
}