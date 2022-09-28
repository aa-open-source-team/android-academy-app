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
}

gradlePlugin {
    plugins {
        register("dependencies-updater") {
            id = "dependencies-updater"
            implementationClass = "io.github.androidacademyglobal.plugins.DependenciesUpdaterPlugin"
        }
    }
}
