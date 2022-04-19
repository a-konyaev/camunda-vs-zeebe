pluginManagement {
    repositories {
        maven("https://plugins.gradle.org/m2/")
    }
}

rootProject.name = "camunda-vs-zeebe"

include("common")
include("storage")
include("scoring")
include("camunda-app")
include("zeebe-app")
