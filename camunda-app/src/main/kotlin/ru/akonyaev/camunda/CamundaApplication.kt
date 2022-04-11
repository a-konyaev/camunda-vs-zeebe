package ru.akonyaev.camunda

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(
    exclude = [DataSourceAutoConfiguration::class]
)
class CamundaApplication

fun main(args: Array<String>) {
    runApplication<CamundaApplication>(*args)
}
