// SupermarketViewModel.kt
package com.example.lab7_retrofit.ui.supermarket.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.lab7_retrofit.database.supermarket.SupermarketItemEntity
import com.example.lab7_retrofit.ui.supermarket.repository.SupermarketRepository
import kotlinx.coroutines.launch

class SupermarketViewModel(private val repository: SupermarketRepository) : ViewModel() {

    val allItems = repository.allItems

    fun insertItem(item: SupermarketItemEntity) {
        viewModelScope.launch {
            repository.insertItem(item)
        }
    }

    fun deleteItem(itemId: String) {
        viewModelScope.launch {
            repository.deleteItem(itemId)
        }
    }
}

class SupermarketViewModelFactory(private val repository: SupermarketRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SupermarketViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SupermarketViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}