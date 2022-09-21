plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
}

kotlin {
    android()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64() // sure all ios dependencies support this target
    ).forEach {
        it.binaries.framework {
            baseName = config.Modules.CORE
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                // Serialization
                implementation(libs.serialization)

                // Concurrency
                implementation(libs.coroutines)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.coroutinesAndroid)
            }
        }
    }
}

android {
    compileSdk = config.ApplicationConfig.androidCompileSdk
    sourceSets[config.Constants.MAIN].manifest.srcFile(config.Constants.MANIFEST_PATH)
    defaultConfig {
        minSdk = config.ApplicationConfig.androidMinSdk
        targetSdk = config.ApplicationConfig.androidTargetSdk
    }
}
