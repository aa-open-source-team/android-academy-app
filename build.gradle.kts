import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

plugins {
    id(Plugins.versions) version Versions.versionsPlugin
    id(Plugins.detekt) version Versions.detekt
}

buildscript {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev/")
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
        classpath("org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}")
        classpath("com.android.tools.build:gradle:${Versions.androidToolsPlugin}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.dagger}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

detekt {
    toolVersion = Versions.detekt
    config = files("config/detekt/detekt.yml")
}

tasks {
    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
    named<DependencyUpdatesTask>("dependencyUpdates") {
        checkForGradleUpdate = true
        outputFormatter = "json"
        outputDir = "build/dependencyUpdates"
        reportfileName = "report"
    }
}