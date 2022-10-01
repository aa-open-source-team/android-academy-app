dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
            // We add plugins as dependencies for our configuration plugins. Added here for not exposing them to project
            library(
                "versionUpdater",
                "com.github.ben-manes",
                "gradle-versions-plugin"
            ).versionRef("versionUpdater")
            library(
                "detektPlugin",
                "io.gitlab.arturbosch.detekt",
                "detekt-gradle-plugin"
            ).versionRef("detekt")
            library(
                "detektFormatting",
                "io.gitlab.arturbosch.detekt",
                "detekt-formatting"
            ).versionRef("detekt")
        }
    }
}
