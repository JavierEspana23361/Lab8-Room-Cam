package com.example.lab7_retrofit.ui.supermarket.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab7_retrofit.ui.supermarket.repository.SupermarketItem
import com.example.lab7_retrofit.ui.supermarket.repository.SupermarketRepository
import kotlinx.coroutines.launch

class SupermarketViewModel(private val repository: SupermarketRepository) : ViewModel() {

    val allItems = repository.allItems

    fun addItem(name: String, quantity: Int) {
        viewModelScope.launch {
            repository.insert(SupermarketItem(name = name, quantity = quantity))
        }
    }

    fun deleteItem(item: SupermarketItem) {
        viewModelScope.launch {
            repository.delete(item)
        }
    }
}