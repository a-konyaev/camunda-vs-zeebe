pluginManagement {
    repositories {
        maven("https://plugins.gradle.org/m2/")
    }
}

rootProject.name = "camunda-vs-zeebe"

include("common")
include("external-service")
include("camunda-app")
include("zeebe-app")
