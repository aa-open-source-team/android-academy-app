import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

plugins {
    id(config.Plugins.versions) version config.Versions.versionsPlugin
    id(config.Plugins.detekt) version config.Versions.detekt
}

buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev/")
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${config.Versions.kotlin}")
        classpath("org.jetbrains.kotlin:kotlin-serialization:${config.Versions.kotlin}")
        classpath("com.android.tools.build:gradle:${config.Versions.androidToolsPlugin}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${config.Versions.dagger}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

apply(from = "${config.GradleExtraArgs.getGradleSupportFolder(project)}linters.gradle")

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
