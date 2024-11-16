package com.example.lab7_retrofit.ui.camera.view

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import java.io.File
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Composable
fun CameraScreen(navController: NavController, mealName: String) {
    val context = LocalContext.current
    var hasCameraPermission by remember { mutableStateOf(
        ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
    ) }

    val cameraPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        hasCameraPermission = isGranted
    }

    LaunchedEffect(Unit) {
        if (!hasCameraPermission) {
            cameraPermissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }

    if (hasCameraPermission) {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(context)
        val previewView = PreviewView(context)
        val preview = Preview.Builder().build()
        val imageCapture = ImageCapture.Builder().build()

        cameraProviderFuture.addListener({
            val cameraProvider = cameraProviderFuture.get()
            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            // Unbind all use cases before rebinding
            cameraProvider.unbindAll()

            try {
                // Bind use cases to camera
                cameraProvider.bindToLifecycle(
                    context as LifecycleOwner, cameraSelector, preview, imageCapture
                )
                preview.setSurfaceProvider(previewView.surfaceProvider)
            } catch (exc: Exception) {
                // Handle exceptions
            }
        }, ContextCompat.getMainExecutor(context))

        Column(modifier = Modifier.fillMaxSize()) {
            AndroidView(factory = { previewView }, modifier = Modifier.weight(1f))
            Button(onClick = {
                val photoFile = File(context.cacheDir, "${System.currentTimeMillis()}.jpg")
                val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()

                imageCapture.takePicture(outputOptions, ContextCompat.getMainExecutor(context), object : ImageCapture.OnImageSavedCallback {
                    override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                        val resultIntent = Intent().apply {
                            putExtra("mealName", mealName)
                            putExtra("photoPath", photoFile.absolutePath)
                        }
                        (context as Activity).setResult(Activity.RESULT_OK, resultIntent)
                        navController.popBackStack("supermarket", false)
                    }

                    override fun onError(exception: ImageCaptureException) {
                        // Handle error
                    }
                })
            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Take Photo")
            }
        }
    } else {
        Text(text = "Camera permission is required to use this feature.")
    }
}