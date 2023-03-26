plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlinx-serialization")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.nathankrebs.wastewizard"
    compileSdk = AppVersions.COMPILE

    defaultConfig {
        applicationId = "com.nathankrebs.wastewizard"
        minSdk = AppVersions.MIN
        targetSdk = AppVersions.TARGET
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
        kotlinCompilerExtensionVersion = AndroidX.VERSION_COMPOSE_COMPILER
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Kotlin.COROUTINES)
    implementation(Kotlin.COROUTINES_ANDROID)
    implementation(Kotlin.SERIALIZATION)
    implementation(AndroidX.CORE)
    implementation(AndroidX.LIFECYCLE_RUNTIME)
    implementation(AndroidX.ACTIVITY_COMPOSE)
    implementation(AndroidX.COMPOSE_UI)
    implementation(AndroidX.COMPOSE_UI_PREVIEW)
    implementation(AndroidX.COMPOSE_MATERIAL)
    implementation(AndroidX.ROOM_RUNTIME)
    implementation(AndroidX.ROOM_KTX)
    implementation(Networking.KTOR_CORE)
    implementation(Networking.KTOR_CLIENT)
    implementation(Networking.KTOR_CONTENT_NEGOTIATION)
    implementation(Networking.KTOR_SERIALIZATION)

    debugImplementation(AndroidX.COMPOSE_UI_TOOLING)
    debugImplementation(AndroidX.COMPOSE_UI_TEST_MANIFEST)

    ksp(AndroidX.ROOM_COMPILER)

    testImplementation(Testing.JUNIT)

    androidTestImplementation(Testing.JUNIT_EXT)
    androidTestImplementation(Testing.ESPRESSO)
    androidTestImplementation(Testing.JUNIT_UI_COMPOSE)
}