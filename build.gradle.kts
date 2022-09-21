import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

plugins {
    id("com.github.ben-manes.versions")
    id("io.gitlab.arturbosch.detekt")
}

buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev/")
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${libs.versions.kotlin.get()}")
        classpath("org.jetbrains.kotlin:kotlin-serialization:${libs.versions.kotlin.get()}")
        classpath("com.android.tools.build:gradle:${libs.versions.androidToolsPlugin.get()}")
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
