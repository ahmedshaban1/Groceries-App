import Versions.compose

plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {


    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "com.ahmed.groceriesapp"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
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
        kotlinCompilerExtensionVersion = compose
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Deps.androidCore)
    implementation(Deps.appCompat)
    implementation(Deps.material)
    implementation(Deps.composeUi)
    implementation(Deps.composeMaterial)
    implementation(Deps.composePreView)
    implementation(Deps.lifeCycle)
    implementation(Deps.composeActivity)
    testImplementation(Deps.testJunit)
    androidTestImplementation(Deps.androidTestJunit)
    androidTestImplementation(Deps.espressoTest)
    androidTestImplementation(Deps.composeUiTest)
    debugImplementation(Deps.debugCompose)
}