plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.lab7_retrofit"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.lab7_retrofit"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.lifecycle.livedata.ktx.v240)
    implementation(libs.androidx.material3.android)
    implementation(libs.androidx.ui.text.google.fonts)
    implementation(libs.androidx.runtime.livedata)
    val nav_version = "2.8.2"
    // Jetpack Compose integration
    implementation(libs.androidx.navigation.compose.v240)

    // Views/Fragments integration
    implementation(libs.androidx.navigation.fragment.ktx.v240)
    implementation(libs.androidx.navigation.ui.ktx.v240)

    // Feature module support for Fragments
    implementation(libs.androidx.navigation.dynamic.features.fragment)

    // Testing Navigation
    androidTestImplementation(libs.androidx.navigation.testing)

    // Room Database
    val room_version = "2.6.1"
    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation(libs.androidx.room.ktx)
    implementation(libs.coil.compose.v140)

    // RETROFIT
    implementation(libs.gson)
    implementation(libs.retrofit.v290)
    implementation(libs.retrofit2.converter.gson)


    implementation(libs.coil.kt.coil.compose)
    implementation(libs.androidx.core.ktx.v170)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.material.v140)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.v113)
    androidTestImplementation(libs.androidx.espresso.core.v340)
    androidTestImplementation(platform(libs.androidx.compose.bom.v2021110))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}