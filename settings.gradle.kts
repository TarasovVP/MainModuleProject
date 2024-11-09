pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MainSubmoduleProject"
include(":mainapp")
include(":inner")

var submodulesUpdated = false
if (!submodulesUpdated) {
    val file = file("SubModuleProject")
    if (file.exists()) {
        println("SubModuleProject exists.")
        file.delete()
        println("SubModuleProject is deleted.")
    } else {
        println("SubModuleProject exists.")
    }
    val updateResult = exec {
        commandLine("git", "submodule", "update", "--recursive", "--remote")
    }.exitValue

    if (updateResult != 0) {
        throw GradleException("Failed to update SubModuleProject")
    } else {
        println("SubModuleProject updated successfully.")
    }
    include(":submoduleproject")
    project(":submoduleproject").projectDir = file("$rootDir/submoduleproject/app")
    submodulesUpdated = true
}

include(":submoduleproject")
project(":submoduleproject").projectDir = file("$rootDir/submoduleproject/app")
