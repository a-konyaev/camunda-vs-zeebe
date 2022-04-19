package ru.akonyaev.zeebe

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ZeebeApplication

fun main(args: Array<String>) {
    runApplication<ZeebeApplication>(*args)
}
