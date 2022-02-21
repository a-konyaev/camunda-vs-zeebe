package ru.akonyaev.camunda.configuration

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration
import ru.akonyaev.camunda.client.StorageClient

@Configuration
@EnableFeignClients(clients = [StorageClient::class])
class FeignConfiguration
