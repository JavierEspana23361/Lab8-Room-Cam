package com.example.lab7_retrofit.ui.camera.viewmodel

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab7_retrofit.ui.camera.repository.CameraRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CameraViewModel(private val repository: CameraRepository) : ViewModel() {

    fun savePhoto(bitmap: Bitmap) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.savePhoto(bitmap)
        }
    }
}
