package config

object Plugins {
    const val androidPlugin = "android"
    const val appPlugin = "com.android.application"
    const val detekt = "io.gitlab.arturbosch.detekt"
    const val detektFormattingPlugin = "$detekt:detekt-formatting:${Versions.detekt}"
    const val kapt = "kapt"
    const val multiplatform = "multiplatform"
    const val hiltPlugin = "dagger.hilt.android.plugin"
    const val serializationPlugin = "plugin.serialization"
    const val versions = "com.github.ben-manes.versions"
    const val library = "com.android.library"
}