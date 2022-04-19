apply {
    plugin("java")
}

tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
    enabled = false
}

dependencies {
    api(platform("org.springframework.cloud:spring-cloud-dependencies:2021.0.1"))
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
}
