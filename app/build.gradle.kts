import Config.androidBuildTools
import Config.androidCompileSdk
import Config.androidMinSdk
import Config.androidTargetSdk

plugins {
    id(Plugins.appPlugin)
    kotlin(Plugins.androidPlugin)
    kotlin(Plugins.serializationPlugin)
    kotlin(Plugins.kapt)
    id(Plugins.hiltPlugin)
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
        kotlinCompilerExtensionVersion = Versions.compose
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
    implementation(Libs.playServicesAuth)

    // Core
    implementation(Libs.androidCore)

    // Serialization
    implementation(Libs.serialization)

    // DI
    implementation(Libs.dagger)
    kapt(Libs.daggerCompiler)

    implementation(Libs.hilt)
    kapt(Libs.hiltCompiler)
    implementation(Libs.hiltNavigationCompose)

    // Concurrency

    implementation(Libs.coroutines)
    implementation(Libs.coroutinesAndroid)

    // Logging
    implementation(Libs.timber)

    // SharedPreference
    implementation(Libs.dataStore)

    // WorkManager
    implementation(Libs.workManager)
    androidTestImplementation(Libs.workManagerTest)

    implementation(Libs.lifecycle)

    // UI: compose
    implementation(Libs.activityCompose)
    implementation(Libs.vmCompose)
    implementation(Libs.composeCompiler)
    implementation(Libs.composeFoundation)
    implementation(Libs.composeMaterial)
    implementation(Libs.composeUI)
    implementation(Libs.composeTooling)
    implementation(Libs.glideComposeVersion)

    // Testing
    testImplementation(Libs.junit)
    androidTestImplementation(Libs.junitExt)
    androidTestImplementation(Libs.kaspresso)
}