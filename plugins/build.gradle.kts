plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

group = "io.github.androidacademyglobal.plugins"
version = "SNAPSHOT"

// Required since Gradle 4.10+.
repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(libs.versionUpdater)
    implementation(libs.detektPlugin)
}

gradlePlugin {
    plugins {
        register("dependencies-updater") {
            id = "dependencies-updater"
            implementationClass = "io.github.androidacademyglobal.plugins.DependenciesUpdaterPlugin"
        }
        register("detekt-all") {
            id = "detekt-all"
            implementationClass = "io.github.androidacademyglobal.plugins.DetektAllPlugin"
        }
    }
}
