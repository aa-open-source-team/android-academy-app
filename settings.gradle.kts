rootProject.name = "AndroidAcademyApp"
include(":app")
include(":core")
includeBuild("plugins")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev/")
    }
}
