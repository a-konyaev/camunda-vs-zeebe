pluginManagement {
    repositories {
        maven("https://plugins.gradle.org/m2/")
    }
}

rootProject.name = "camunda-vs-zeebe"

include("camunda-app")
include("storage-mock")
