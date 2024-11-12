package com.example.lab7_retrofit.ui.meals.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.lab7_retrofit.navigation.AppBar
import com.example.lab7_retrofit.ui.meals.viewmodel.mealsViewModel

@Composable
fun MealsFilterScreen(navController: NavController, category: String) {
    val viewModel: mealsViewModel = viewModel()

    LaunchedEffect(Unit) {
        viewModel.fcategory(category)
    }

    val meals = viewModel.meals.value ?: emptyList()

    Scaffold(topBar = {
        AppBar(title = "Meals", navController = navController)
    }) {
        Column(modifier = Modifier.fillMaxSize()) {
            LazyColumn {
                items(meals) { meal ->
                    MealCategoryC(meal, navController)
                }
            }
        }
    }
}