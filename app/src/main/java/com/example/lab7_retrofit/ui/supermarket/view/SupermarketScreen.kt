// SupermarketScreen.kt
package com.example.lab7_retrofit.ui.supermarket.view

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.lab7_retrofit.MyApp
import com.example.lab7_retrofit.database.supermarket.SupermarketItemEntity
import com.example.lab7_retrofit.navigation.AppBar
import com.example.lab7_retrofit.networking.MealsWebService
import com.example.lab7_retrofit.ui.camera.view.CameraActivity
import com.example.lab7_retrofit.ui.supermarket.repository.SupermarketRepository
import com.example.lab7_retrofit.ui.supermarket.viewmodel.SupermarketViewModel
import com.example.lab7_retrofit.ui.supermarket.viewmodel.SupermarketViewModelFactory
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
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

    var mealName by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            val photoPath = data?.getStringExtra("photoPath")
            if (photoPath != null) {
                val newItem = SupermarketItemEntity(
                    name = mealName,
                    quantity = "1",
                    imagePath = photoPath
                )
                supermarketViewModel.insertItem(newItem)
            }
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Enter Meal Name") },
            text = {
                Column {
                    OutlinedTextField(
                        value = mealName,
                        onValueChange = { mealName = it },
                        label = { Text("Meal Name") }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {
                        showDialog = false
                        if (mealName.isNotEmpty()) {
                            val intent = Intent(context, CameraActivity::class.java).apply {
                                putExtra("mealName", mealName)
                            }
                            launcher.launch(intent)
                        }
                    }) {
                        Text("Open Camera")
                    }
                }
            },
            confirmButton = {
                Button(onClick = { showDialog = false }) {
                    Text("OK")
                }
            },
            dismissButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    Scaffold(
        topBar = {
            AppBar(title = "Supermarket List", navController = navController)
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { showDialog = true }) {
                Icon(Icons.Filled.Add, contentDescription = "Add Food")
            }
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            LazyColumn {
                items(items) { item ->
                    SupermarketItemRow(item = item, onDelete = { id -> supermarketViewModel.deleteItem(id) })
                }
            }
        }
    }
}


fun createImageFile(context: Context): File {
    val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())
    val storageDir: File? = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
    return File.createTempFile(
        "JPEG_${timeStamp}_",
        ".jpg",
        storageDir
    )
}

fun getUriForFile(context: Context, file: File): Uri {
    return FileProvider.getUriForFile(context, "${context.packageName}.fileprovider", file)
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
