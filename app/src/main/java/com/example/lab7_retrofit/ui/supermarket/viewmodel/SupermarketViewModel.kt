package com.example.lab7_retrofit.ui.supermarket.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.lab7_retrofit.ui.supermarket.repository.SupermarketRepository
import kotlinx.coroutines.launch

class SupermarketViewModel(private val repository: SupermarketRepository) : ViewModel() {

    val allItems = repository.allItems

    val idlist = mutableListOf<String>()

    init {
        fetchItems()
    }

    private fun fetchItems() {
        viewModelScope.launch {
            repository.fetchItems(mealId = idlist.joinToString(separator = ","))
        }
    }

    fun addItem(mealId: String) {
        idlist.add(mealId)

    }

    fun deleteItem(mealId: String) {
        viewModelScope.launch {
            repository.delete(mealId)
            fetchItems()
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