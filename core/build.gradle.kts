plugins {
    kotlin(config.Plugins.multiplatform)
    id(config.Plugins.library)
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
}

android {
    compileSdk = config.ApplicationConfig.androidCompileSdk
    sourceSets[config.Constants.MAIN].manifest.srcFile(config.Constants.MANIFEST_PATH)
    defaultConfig {
        minSdk = config.ApplicationConfig.androidMinSdk
        targetSdk = config.ApplicationConfig.androidTargetSdk
    }
}