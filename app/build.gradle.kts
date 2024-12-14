plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.montenegro.weatherapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.montenegro.weatherapp"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx) // Core KTX library
    implementation(libs.androidx.lifecycle.runtime.ktx) // Lifecycle Runtime KTX library
    implementation(libs.androidx.activity.compose) // Activity Compose library
    implementation(platform(libs.androidx.compose.bom)) // Compose BOM library
    implementation(libs.androidx.ui) // Compose UI library
    implementation(libs.androidx.ui.graphics) // Compose UI Graphics library
    implementation(libs.androidx.ui.tooling.preview) // Compose UI Tooling Preview library
    implementation(libs.androidx.material3) // Material3 library
    implementation(libs.androidx.constraintlayout.compose) // ConstraintLayout Compose library
    testImplementation(libs.junit) // JUnit library
    androidTestImplementation(libs.androidx.junit) // AndroidX JUnit library
    androidTestImplementation(libs.androidx.espresso.core) // Espresso Core library
    androidTestImplementation(platform(libs.androidx.compose.bom)) // Compose BOM library for Android tests
    androidTestImplementation(libs.androidx.ui.test.junit4) // Compose UI Test JUnit4 library
    debugImplementation(libs.androidx.ui.tooling) // Compose UI Tooling library for debugging
    debugImplementation(libs.androidx.ui.test.manifest) // Compose UI Test Manifest library for debugging
}
