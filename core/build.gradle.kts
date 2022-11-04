plugins {
    alias(libs.plugins.multiplatformPlugin)
    alias(libs.plugins.serializationPlugin)
    alias(libs.plugins.libraryPlugin)
}

kotlin {
    android()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64() // sure all ios dependencies support this target
    ).forEach {
        it.binaries.framework {
            baseName = "core"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                // Serialization
                implementation(libs.serialization)

                // Concurrency
                implementation(libs.coroutines)

                // Network
                implementation(libs.ktor.core)
                implementation(libs.ktor.logging)
                implementation(libs.ktor.resources)
                implementation(libs.ktor.json)
                implementation(libs.ktor.content.negotiation)

                api(libs.koin.core)

                // Logging
                api(libs.napier)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.coroutinesAndroid)
                implementation(libs.ktor.okhttp)
            }
        }
    }
}

android {
    compileSdk = io.github.androidacademyglobal.config.ApplicationConfig.androidCompileSdk
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = io.github.androidacademyglobal.config.ApplicationConfig.androidMinSdk
        targetSdk = io.github.androidacademyglobal.config.ApplicationConfig.androidTargetSdk
    }
    namespace = "io.github.aag.core"
}
