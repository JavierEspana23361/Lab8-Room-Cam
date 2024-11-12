package com.example.lab7_retrofit.ui.mealdetail.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.lab7_retrofit.navigation.AppBar
import com.example.lab7_retrofit.networking.response.mealdetail.mealdetail
import com.example.lab7_retrofit.ui.mealdetail.viewmodel.mealdetailViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MealsDetailScreen(navController: NavController, mealId: String) {
    val context = LocalContext.current
    val viewModel: mealdetailViewModel = ViewModelProvider(context as ViewModelStoreOwner).get(mealdetailViewModel::class.java)

    LaunchedEffect(Unit) {
        viewModel.lmealdetail(mealId)
    }

    val mealDetail = viewModel.mealDetail.value

    Scaffold(
        topBar = {
            AppBar(title = "Details", navController = navController)
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* No action for now */ }) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }
        }
    ) {
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            mealDetail?.let { meal ->
                item {
                    MealCategoryB(meal = meal, navController = navController)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMealsDetailScreen() {
    MealsDetailScreen(navController = rememberNavController(), mealId = "1")
}