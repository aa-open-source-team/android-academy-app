import config.ApplicationConfig.androidBuildTools
import config.ApplicationConfig.androidCompileSdk
import config.ApplicationConfig.androidMinSdk
import config.ApplicationConfig.androidTargetSdk

plugins {
    id(config.Plugins.appPlugin)
    kotlin(config.Plugins.androidPlugin)
    kotlin(config.Plugins.kapt)
    id(config.Plugins.hiltPlugin)
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
        kotlinCompilerExtensionVersion = config.Versions.compose
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
    implementation(config.Libs.playServicesAuth)

    // Core
    implementation(config.Libs.androidCore)

    // DI
    implementation(config.Libs.dagger)
    kapt(config.Libs.daggerCompiler)

    implementation(config.Libs.hilt)
    kapt(config.Libs.hiltCompiler)
    implementation(config.Libs.hiltNavigationCompose)

    // Logging
    implementation(config.Libs.timber)

    // SharedPreference
    implementation(config.Libs.dataStore)

    // WorkManager
    implementation(config.Libs.workManager)
    androidTestImplementation(config.Libs.workManagerTest)

    implementation(config.Libs.lifecycle)

    // UI: compose
    implementation(config.Libs.activityCompose)
    implementation(config.Libs.vmCompose)
    implementation(config.Libs.composeCompiler)
    implementation(config.Libs.composeFoundation)
    implementation(config.Libs.composeMaterial)
    implementation(config.Libs.composeUI)
    implementation(config.Libs.composeTooling)
    implementation(config.Libs.glideComposeVersion)
    implementation(config.Libs.composeMaterial3)

    // Testing
    testImplementation(config.Libs.junit)
    androidTestImplementation(config.Libs.junitExt)
    androidTestImplementation(config.Libs.kaspresso)
}
