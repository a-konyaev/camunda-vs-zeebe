import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    val kotlinVersion = "1.6.10"

    id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
    id("org.springframework.boot") version "2.6.3" apply false

    // TODO if add 'apply false' then build will fail...
    id("org.jetbrains.kotlin.jvm") version kotlinVersion
    id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion apply false
}

allprojects {
    group = "ru.akonyaev.zeebe.demo"

    repositories {
        maven("https://repo1.maven.org/maven2/")
    }
}

subprojects {
    apply {
        plugin("io.spring.dependency-management")
        plugin("org.springframework.boot")
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.plugin.spring")
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web-services")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.1")

        implementation("io.github.microutils:kotlin-logging:2.1.21")
        implementation("net.logstash.logback:logstash-logback-encoder:7.0.1")

        implementation("org.springdoc:springdoc-openapi-ui:1.6.6")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }

    java.sourceCompatibility = JavaVersion.VERSION_17

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
