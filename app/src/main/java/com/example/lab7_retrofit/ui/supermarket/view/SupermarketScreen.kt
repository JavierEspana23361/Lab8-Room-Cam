package com.example.lab7_retrofit.ui.supermarket.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.lab7_retrofit.MyApp
import com.example.lab7_retrofit.navigation.AppBar
import com.example.lab7_retrofit.ui.supermarket.repository.SupermarketRepository
import com.example.lab7_retrofit.ui.supermarket.viewmodel.SupermarketViewModel
import com.example.lab7_retrofit.ui.supermarket.viewmodel.SupermarketViewModelFactory
import com.example.lab7_retrofit.database.supermarket.SupermarketItemEntity
import com.example.lab7_retrofit.networking.MealsWebService

@Composable
fun SupermarketScreen(navController: NavController) {
    val context = LocalContext.current
    val app = context.applicationContext as MyApp
    val supermarketRepository = SupermarketRepository(
        webService = MealsWebService(),
        dao = app.database.supermarketItemDao()
    )

    val supermarketViewModel: SupermarketViewModel = viewModel(
        factory = SupermarketViewModelFactory(supermarketRepository)
    )
    val items by supermarketViewModel.allItems.collectAsState(initial = emptyList())

    Scaffold(topBar = {
        AppBar(title = "Supermarket List", navController = navController)
    }) {
        Column(modifier = Modifier.padding(it)) {
            LazyColumn {
                items(items) { item: SupermarketItemEntity ->
                    SupermarketItemRow(item = item, onDelete = { id -> supermarketViewModel.deleteItem(id) })
                }
            }
        }
    }
}

@Composable
fun SupermarketItemRow(item: SupermarketItemEntity, onDelete: (String) -> Unit) {
    Row(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = rememberAsyncImagePainter(item.imagePath),
            contentDescription = null,
            modifier = Modifier.size(88.dp).padding(4.dp)
        )
        Column(modifier = Modifier.weight(1f).align(Alignment.CenterVertically).padding(16.dp)) {
            Text(text = item.name, style = MaterialTheme.typography.titleSmall)
        }
        Button(onClick = { onDelete(item.id.toString()) }) {
            Text("Delete")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSupermarketScreen() {
    SupermarketScreen(navController = rememberNavController())
}