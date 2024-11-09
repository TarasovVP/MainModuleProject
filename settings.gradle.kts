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
    if (!file("SubModuleProject").exists()) {
        println("SubModuleProject directory not found. Cloning...")
        val cloneResult = exec {
            commandLine("git", "clone", "--recurse-submodules", "https://github.com/TarasovVP/SubModuleProject.git", "SubModuleProject")
        }.exitValue
        if (cloneResult != 0) {
            throw GradleException("Failed to clone SubModuleProject")
        } else {
            println("SubModuleProject cloned successfully")
        }
    } else {
        println("SubModuleProject directory found. Updating...")
        val updateResult = exec {
            workingDir("SubModuleProject")
            commandLine("git", "submodule", "update", "--remote", "--merge", "--force")
        }.exitValue
        if (updateResult != 0) {
            throw GradleException("Failed to update sub modules")
        } else {
            println("Sub modules updated successfully")
        }
    }
    submodulesUpdated = true
}

include(":submoduleproject")
project(":submoduleproject").projectDir = file("$rootDir/submoduleproject/app")
