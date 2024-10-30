package com.example.lab7_retrofit.ui.mealdetail.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab7_retrofit.networking.response.mealdetail.mealdetail
import com.example.lab7_retrofit.networking.response.mealdetail.mealdetailResponse
import com.example.lab7_retrofit.ui.mealdetail.repository.mealdetailRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class mealdetailViewModel(private val repository: mealdetailRepository = mealdetailRepository()) : ViewModel() {

    private val _mealDetail = MutableLiveData<mealdetail>()
    val mealDetail: LiveData<mealdetail> = _mealDetail

    fun lmealdetail(mealId: String) {
        viewModelScope.launch {
            try {
                val response = repository.getmealdetail(mealId)

                response.enqueue(object : Callback<mealdetailResponse> {
                    override fun onResponse(
                        call: Call<mealdetailResponse>,
                        response: Response<mealdetailResponse>
                    ) {
                        if (response.isSuccessful) {
                            _mealDetail.value = response.body()?.meals?.firstOrNull()
                        } else {
                            Log.e("MealDetailViewModel", "Error: ${response.errorBody()?.string()}")
                        }
                    }
                    override fun onFailure(call: Call<mealdetailResponse>, t: Throwable) {
                        Log.e("MealDetailViewModel", t.message.toString())
                    }
                }
                )

            } catch (e: Exception) {
                Log.e("MealDetailViewModel", e.message.toString())
            }
        }
    }
}
