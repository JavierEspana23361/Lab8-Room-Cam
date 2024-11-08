package com.example.lab7_retrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.lab7_retrofit.navigation.AppBar
import com.example.lab7_retrofit.navigation.Navigation
import com.example.lab7_retrofit.navigation.NavigationState
import com.example.lab7_retrofit.ui.theme.Lab7Theme
import com.example.lab7_retrofit.ui.categories.viewmodel.MealViewModelFactory
import com.example.lab7_retrofit.ui.meals.viewmodel.mealsViewModel
import com.example.lab7_retrofit.ui.categories.viewmodel.categoriesViewModel



class MainActivity : ComponentActivity() {

    private lateinit var mealViewModel: categoriesViewModel


    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = (applicationContext as MealsApp).categoryRepository
        mealViewModel = ViewModelProvider(
            this,
            MealViewModelFactory(repository))[categoriesViewModel::class.java]


        enableEdgeToEdge()
        setContent {
            Lab7Theme {
                Navigation(navController = rememberNavController())
            }
        }
    }
}