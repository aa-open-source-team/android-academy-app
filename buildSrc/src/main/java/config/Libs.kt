package config

object Libs {
    // Android libs
    const val androidCore = "androidx.core:core-ktx:${Versions.androidCore}"
    const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val composeCompiler = "androidx.compose.compiler:compiler:${Versions.compose}"
    const val composeUI = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composeFoundation = "androidx.compose.foundation:foundation:${Versions.compose}"
    const val composeTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val vmCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle}"

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
    const val composeMaterial3 = "androidx.compose.material3:material3:${Versions.material3}"

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
