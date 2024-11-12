package com.example.lab7_retrofit.ui.categories.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab7_retrofit.networking.response.categories.categories
import com.example.lab7_retrofit.ui.categories.repository.categoriesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class categoriesViewModel(private val repository: categoriesRepository = categoriesRepository()): ViewModel() {

    val mealsState: MutableState<List<categories>> =  mutableStateOf(emptyList<categories>())

    init {
        Log.d("TAG_COROUTINES", "about to launch a coroutine")
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("TAG_COROUTINES", "launching a coroutine")
            val meals = getcategories()
            Log.d("TAG_COROUTINES", "we have received sync data")
            mealsState.value = meals
        }
        Log.d("TAG_COROUTINES", "other work")
    }

    private suspend fun getcategories(): List<categories> {
        return repository.getcategories()
    }
}