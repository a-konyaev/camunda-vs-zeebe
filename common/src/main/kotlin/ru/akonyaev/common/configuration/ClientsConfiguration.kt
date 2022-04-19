package ru.akonyaev.common.configuration

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration
import ru.akonyaev.common.interaction.ScoringClient
import ru.akonyaev.common.interaction.StorageClient

@Configuration
@EnableFeignClients(
    clients = [
        StorageClient::class,
        ScoringClient::class
    ]
)
class ClientsConfiguration
