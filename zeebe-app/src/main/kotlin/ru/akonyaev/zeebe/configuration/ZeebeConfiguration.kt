package ru.akonyaev.zeebe.configuration

import io.camunda.zeebe.client.api.JsonMapper
import io.camunda.zeebe.spring.client.EnableZeebeClient
import io.camunda.zeebe.spring.client.annotation.ZeebeDeployment
import io.camunda.zeebe.spring.client.properties.ZeebeClientConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableZeebeClient
@EnableConfigurationProperties(ZeebeClientConfigurationProperties::class)
class ZeebeConfiguration {

    @Bean
    fun jsonMapper(): JsonMapper {
        return CustomZeebeJsonMapper()
    }

    @Configuration
    @ZeebeDeployment(
        resources = [
            "classpath*:/**/*.bpmn",
            "classpath*:/**/*.dmn"
        ]
    )
    class ZeebeDeploymentConfiguration
}
