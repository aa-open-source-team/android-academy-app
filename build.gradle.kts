plugins {
    id("dependencies-updater")
    id("detekt-all")
    alias(libs.plugins.appPlugin) apply false
    alias(libs.plugins.androidPlugin) apply false
    alias(libs.plugins.libraryPlugin) apply false
    alias(libs.plugins.kspPlugin) apply false
    alias(libs.plugins.multiplatformPlugin) apply false
    alias(libs.plugins.serializationPlugin) apply false
    alias(libs.plugins.crashlyticsPlugin) apply false
    alias(libs.plugins.gservicesPlugin) apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
