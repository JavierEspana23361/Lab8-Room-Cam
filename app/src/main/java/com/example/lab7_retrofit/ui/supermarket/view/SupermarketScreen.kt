package com.example.lab7_retrofit.ui.supermarket.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lab7_retrofit.navigation.AppBar
import com.example.lab7_retrofit.ui.supermarket.repository.SupermarketRepository
import com.example.lab7_retrofit.ui.supermarket.viewmodel.SupermarketViewModel
import com.example.lab7_retrofit.ui.supermarket.viewmodel.SupermarketViewModelFactory
import com.example.lab7_retrofit.networking.response.mealdetail.mealdetail

@Composable
fun SupermarketScreen(navController: NavController) {
    val context = LocalContext.current
    val supermarketRepository = SupermarketRepository()
    val viewModel: SupermarketViewModel = viewModel(
        factory = SupermarketViewModelFactory(supermarketRepository)
    )
    val items by viewModel.mealDetail.observeAsState(initial = emptyList())

    Scaffold(topBar = {
        AppBar(title = "Supermarket List", navController = navController)
    }) {
        Column(modifier = Modifier.padding(it)) {
            LazyColumn {
                items(items) { item: mealdetail ->
                    Row(modifier = Modifier.padding(8.dp)) {
                        Text(text = item.name, modifier = Modifier.weight(1f))
                        Button(onClick = { viewModel.deleteItem(item.id) }) {
                            Text("Delete")
                        }
                    }
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