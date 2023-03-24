rootProject.name = "AndroidAcademyApp"
include(":app")
include(":core")
includeBuild("plugins")

pluginManagement {
    plugins {
        id("org.gradle.toolchains.foojay-resolver-convention") version "0.4.0"
    }
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev/")
    }
}
