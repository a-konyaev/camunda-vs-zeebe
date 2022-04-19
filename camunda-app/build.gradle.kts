dependencies {
    implementation(project(":common"))

    implementation("org.springframework.kafka:spring-kafka")

    api(platform("org.camunda.bpm:camunda-bom:7.16.0"))
    implementation("org.camunda.bpm:camunda-bom")
    implementation("org.camunda.bpm.model:camunda-dmn-model")
    implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-webapp")

    implementation("org.postgresql:postgresql:42.3.3")
    implementation("com.zaxxer:HikariCP")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}
