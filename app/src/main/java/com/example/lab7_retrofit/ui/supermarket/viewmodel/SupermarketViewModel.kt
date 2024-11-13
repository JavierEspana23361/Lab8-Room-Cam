package com.example.lab7_retrofit.ui.supermarket.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.lab7_retrofit.networking.response.mealdetail.mealdetail
import com.example.lab7_retrofit.ui.supermarket.repository.SupermarketRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException

class SupermarketViewModel(private val repository: SupermarketRepository) : ViewModel() {

    val allItems = repository.allItems

    val idlist = mutableListOf<String>()

    private val _mealDetail = MutableLiveData<List<mealdetail>>()
    val mealDetail: LiveData<List<mealdetail>> = _mealDetail

    fun addItem(mealId: String) {
        idlist.add(mealId)
        Log.d("SupermarketViewModel", "Added list $idlist")
        Log.d("SupermarketViewModel", "Added item $mealId")
        fetchItems()
    }


    fun deleteItem(mealId: String) {
        idlist.remove(mealId)
        fetchItems()
    }

    private fun fetchItems() {
        viewModelScope.launch {
            try {
                val details = idlist.map { mealId ->
                    repository.getmealdetail(mealId).meals.firstOrNull()
                }.filterNotNull()
                _mealDetail.value = details
            } catch (e: HttpException) {
                Log.e("SupermarketViewModel", "HTTP error: ${e.message()}")
            } catch (e: Exception) {
                Log.e("SupermarketViewModel", "Error: ${e.message}")
            }
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