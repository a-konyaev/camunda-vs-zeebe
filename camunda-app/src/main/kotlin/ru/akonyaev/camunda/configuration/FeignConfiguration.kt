package ru.akonyaev.camunda.configuration

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration
import ru.akonyaev.camunda.interaction.ScoringClient
import ru.akonyaev.camunda.interaction.StorageClient

@Configuration
@EnableFeignClients(
    clients = [
        StorageClient::class,
        ScoringClient::class
    ]
)
class FeignConfiguration
