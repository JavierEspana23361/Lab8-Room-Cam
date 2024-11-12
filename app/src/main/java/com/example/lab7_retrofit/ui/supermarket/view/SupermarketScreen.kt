package com.example.lab7_retrofit.ui.supermarket.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lab7_retrofit.navigation.AppBar
import com.example.lab7_retrofit.ui.supermarket.viewmodel.SupermarketViewModel

@Composable
fun SupermarketScreen(navController: NavController) {
    val viewModel: SupermarketViewModel = viewModel()
    val items by viewModel.allItems.collectAsState(initial = emptyList())

    Scaffold(topBar = {
        AppBar(title = "Supermarket List", navController = navController)
    }) {
        Column {
            LazyColumn {
                items(items) { item ->
                    Text(text = "${item.name} - ${item.quantity}")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSupermarketScreen() {
    SupermarketScreen(navController = rememberNavController())
}