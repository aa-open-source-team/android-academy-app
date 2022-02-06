object Config {
    // Android config
    const val androidBuildTools = "31.0.0"
    const val androidMinSdk = 21
    const val androidTargetSdk = 31
    const val androidCompileSdk = 31
    const val applicationId = "com.github.mik629.android.fundamentals"
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {
    const val kotlin = "1.5.31"
    const val activityCompose = "1.4.0"
    const val compose = "1.0.5"
    const val vmCompose = "2.4.0-rc01"
    const val navigationCompose = "2.4.0-alpha10"
    const val hiltNavigationCompose = "1.0.0-rc01"
    const val lifecycle = "2.4.0"
    const val workManager = "2.7.1"

    // Plugins
    const val androidToolsPlugin = "7.0.4"
    const val versionsPlugin = "0.41.0"

    // Android libraries
    const val androidCore = "1.7.0"
    const val coroutines = "1.6.0"
    const val dagger = "2.40.5"
    const val dataStore = "1.0.0"
    const val playServicesAuth = "20.0.1"
    const val serialization = "1.3.2"
    const val material3 = "1.0.0-alpha04"

    // third party libs
    const val glideCompose = "1.4.5"
    const val timber = "5.0.1"

    // testing
    const val junit = "4.13.2"
    const val junitExt = "1.1.3"
    const val kaspresso = "1.4.0"
}

object Plugins {
    const val androidPlugin = "android"
    const val appPlugin = "com.android.application"
    const val kapt = "kapt"
    const val hiltPlugin = "dagger.hilt.android.plugin"
    const val serializationPlugin = "plugin.serialization"
    const val versions = "com.github.ben-manes.versions"
}

object Libs {
    // Android libs
    const val androidCore = "androidx.core:core-ktx:${Versions.androidCore}"
    const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val composeCompiler = "androidx.compose.compiler:compiler:${Versions.compose}"
    const val composeUI = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composeFoundation = "androidx.compose.foundation:foundation:${Versions.compose}"
    const val composeTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val vmCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.vmCompose}"

    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.dagger}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.dagger}"
    const val hiltNavigationCompose =
        "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}"

    const val dataStore = "androidx.datastore:datastore-preferences:${Versions.dataStore}"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val playServicesAuth =
        "com.google.android.gms:play-services-auth:${Versions.playServicesAuth}"
    const val serialization =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serialization}"
    const val workManager = "androidx.work:work-runtime-ktx:${Versions.workManager}"

    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val material3 = "androidx.compose.material3:material3:${Versions.material3}"

    // third party libs
    const val glideComposeVersion = "com.github.skydoves:landscapist-glide:${Versions.glideCompose}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    // testing
    const val junit = "junit:junit:${Versions.junit}"
    const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
    const val kaspresso =
        "com.kaspersky.android-components:kaspresso-compose-support:${Versions.kaspresso}"
    const val workManagerTest = "androidx.work:work-testing:${Versions.workManager}"
}