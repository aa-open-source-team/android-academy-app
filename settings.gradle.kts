rootProject.name = "AndroidAcademyApp"
include(":app")
include(":core")
enableFeaturePreview("VERSION_CATALOGS") // https://sourcediving.com/manage-your-gradle-dependencies-with-version-catalog-not-only-in-android-114117647cdb
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS") // https://proandroiddev.com/using-type-safe-project-dependencies-on-gradle-493ab7337aa

pluginManagement {
    plugins {
        kotlin("android") version ("7.3")
        id("com.android.application") version ("7.3.0")
        id("io.gitlab.arturbosch.detekt") version ("1.21.0")
        id("multiplatform")
        kotlin("plugin.serialization")
        kotlin("kapt")
        id("com.android.library")
        id("com.github.ben-manes.versions") version ("0.42.0")
    }
}
