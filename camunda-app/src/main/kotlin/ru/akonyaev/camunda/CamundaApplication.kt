package ru.akonyaev.camunda

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import
import ru.akonyaev.common.configuration.ClientsConfiguration

@SpringBootApplication(
    exclude = [DataSourceAutoConfiguration::class]
)
@Import(ClientsConfiguration::class)
class CamundaApplication

fun main(args: Array<String>) {
    runApplication<CamundaApplication>(*args)
}
