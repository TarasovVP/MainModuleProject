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

/*var submodulesUpdated = false
if (!submodulesUpdated) {
    val submodulePath = file("SubModuleProject")
    if (submodulePath.exists()) {
        println("SubModuleProject exists.")
        submodulePath.delete()
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
    repeat(5) { attempt ->
        if (submodulePath.exists() && submodulePath.list()?.isNotEmpty() == true) {
            println("SubModuleProject is fully updated and ready.")
            return@repeat 
        } else {
            println("Waiting for SubModuleProject to be ready... Attempt ${attempt + 1}/5")
            Thread.sleep(5000)
        }
    }

    if (submodulePath.list()?.isEmpty() == true) {
        throw GradleException("SubModuleProject update did not complete as expected.")
    } else {
        println("SubModuleProject is fully updated and ready(final).")
    }
    include(":submoduleproject")
    project(":submoduleproject").projectDir = file("$rootDir/submoduleproject/app")
    submodulesUpdated = true
}*/

include(":submoduleproject")
project(":submoduleproject").projectDir = file("$rootDir/submoduleproject/app")
