import io.github.androidacademyglobal.config.ApplicationConfig.androidBuildTools
import io.github.androidacademyglobal.config.ApplicationConfig.androidCompileSdk
import io.github.androidacademyglobal.config.ApplicationConfig.androidMinSdk
import io.github.androidacademyglobal.config.ApplicationConfig.androidTargetSdk

plugins {
    alias(libs.plugins.appPlugin)
    alias(libs.plugins.androidPlugin)
    alias(libs.plugins.kspPlugin)
    alias(libs.plugins.crashlyticsPlugin)
    alias(libs.plugins.gservicesPlugin)
}

android {
    compileSdk = androidCompileSdk
    buildToolsVersion = androidBuildTools

    defaultConfig {
        applicationId = "io.github.androidacademyglobal"
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
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    namespace = "io.github.androidacademyglobal"
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    implementation(project(":core"))

    // auth
    implementation(libs.playServicesAuth)

    // firebase crashlytics
    implementation(platform(libs.firebase))
    implementation(libs.firebase.crashlytics)
    implementation(libs.firebase.analytics)

    // Core
    implementation(libs.androidCore)

    // DI
    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.koin.compose)

    implementation(libs.lifecycle)

    // UI: compose
    val composeBom = platform(libs.compose.bom)
    implementation(composeBom)
    implementation(libs.activityCompose)
    implementation(libs.vmCompose)
    implementation(libs.lifecycleCompose)
    implementation(libs.composeCompiler)
    implementation(libs.composeFoundation)
    implementation(libs.composeMaterial)
    implementation(libs.composeUI)
    implementation(libs.composeTooling)
    implementation(libs.composeMaterial3)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.junitExt)
    androidTestImplementation(libs.kaspresso)
}
