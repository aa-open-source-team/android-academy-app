package config

import org.gradle.api.Project

object GradleExtraArgs {

    @JvmStatic
    fun getRootProjectPath(project: Project): String = project.rootProject.projectDir.path

    @JvmStatic
    fun getGradleSupportFolder(project: Project): String =
        "${getRootProjectPath(project)}/gradle_support/"

    @JvmStatic
    fun getLintersConfigFolder(project: Project): String = "${getRootProjectPath(project)}/linters/"
}