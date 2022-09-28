import config.ApplicationConfig.androidBuildTools
import config.ApplicationConfig.androidCompileSdk
import config.ApplicationConfig.androidMinSdk
import config.ApplicationConfig.androidTargetSdk

plugins {
    alias(libs.plugins.appPlugin)
    alias(libs.plugins.androidPlugin)
    alias(libs.plugins.kaptPlugin)
}

android {
    compileSdk = androidCompileSdk
    buildToolsVersion = androidBuildTools

    defaultConfig {
        applicationId = "io.github.android_academy_global"
        minSdk = androidMinSdk
        targetSdk = androidTargetSdk
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
        }
        getByName("release") {
            isMinifyEnabled = true
            isDebuggable = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
        kotlinCompilerVersion = libs.versions.compose.get()
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":core"))

    // auth
    implementation(libs.playServicesAuth)

    // Core
    implementation(libs.androidCore)

    // DI

    // Logging
    implementation(libs.timber)

    // SharedPreference
    implementation(libs.dataStore)

    // WorkManager
    implementation(libs.workManager)
    androidTestImplementation(libs.workManagerTest)

    implementation(libs.lifecycle)

    // UI: compose
    implementation(libs.activityCompose)
    implementation(libs.vmCompose)
    implementation(libs.composeCompiler)
    implementation(libs.composeFoundation)
    implementation(libs.composeMaterial)
    implementation(libs.composeUI)
    implementation(libs.composeTooling)
    implementation(libs.glideComposeVersion)
    implementation(libs.composeMaterial3)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.junitExt)
    androidTestImplementation(libs.kaspresso)
}
