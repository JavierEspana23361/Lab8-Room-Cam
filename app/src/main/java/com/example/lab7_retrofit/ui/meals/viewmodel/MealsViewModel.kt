package com.example.lab7_retrofit.ui.meals.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab7_retrofit.networking.MealsWebService
import com.example.lab7_retrofit.networking.response.meals.meals
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.net.ConnectException
import androidx.navigation.NavHostController
import com.example.lab7_retrofit.ui.meals.repository.mealsRepository
import kotlinx.coroutines.launch

class mealsViewModel (val repository: mealsRepository = mealsRepository()): ViewModel() {

    private val _meals = MutableLiveData<List<meals>>()
    val meals: LiveData<List<meals>> = _meals

    fun fcategory(category: String) {
        viewModelScope.launch {
            try {
                val meals = repository.filtercategory(category)
                _meals.value = meals
            } catch (e: Exception) {
                Log.e("mealsViewModel", e.message.toString());
            }
        }
    }
}