package io.github.androidacademyglobal.plugins

import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektPlugin
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.named

class DetektAllPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            configureDetekt()
        }
    }

    private fun Project.configureDetekt() {
        apply<DetektPlugin>()
        tasks.named<Detekt>("detekt") {
            reports {
                xml.required.set(false)
                html.required.set(false)
                sarif.required.set(false)

                txt {
                    outputLocation.set(file("build/reports/detekt.txt"))
                    required.set(true) // reports can also be enabled and disabled at the task level as needed
                }
            }
            parallel = true
            allRules = false
            buildUponDefaultConfig = true

            configure<Detekt> {

            }
        }
        project.extensions.configure<DetektExtension> {
            config =
                project.files("$rootDir/linters/detekt-config.yml")
            source = files(
                subprojects
                    .flatMap { pr ->
                        listOf(
                            "${pr.projectDir}/src/main/java",
                            "${pr.projectDir}/src/main/kotlin",
                            "${pr.projectDir}/src/test/java",
                            "${pr.projectDir}/src/androidTest/java"
                        )
                    }
            )
        }
    }
}
