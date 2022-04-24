package ru.akonyaev.zeebe

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import
import ru.akonyaev.common.configuration.ClientsConfiguration

@SpringBootApplication
@Import(ClientsConfiguration::class)
class ZeebeApplication

fun main(args: Array<String>) {
    runApplication<ZeebeApplication>(*args)
}
