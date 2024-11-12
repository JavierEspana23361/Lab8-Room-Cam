package com.example.lab7_retrofit.ui.mealdetail.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab7_retrofit.networking.response.mealdetail.mealdetail
import com.example.lab7_retrofit.ui.mealdetail.repository.mealdetailRepository
import kotlinx.coroutines.launch

class mealdetailViewModel(private val repository: mealdetailRepository = mealdetailRepository()) : ViewModel() {

    private val _mealDetail = MutableLiveData<mealdetail>()
    val mealDetail: LiveData<mealdetail> = _mealDetail

    fun lmealdetail(mealId: String) {
        viewModelScope.launch {
            try {
                val response = repository.getmealdetail(mealId)
                _mealDetail.value = response.meals.firstOrNull()
            } catch (e: Exception) {
                Log.e("MealDetailViewModel", e.message.toString())
            }
        }
    }
}