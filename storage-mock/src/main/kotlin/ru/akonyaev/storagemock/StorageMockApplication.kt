package ru.akonyaev.storagemock

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StorageMockApplication

fun main(args: Array<String>) {
    runApplication<StorageMockApplication>(*args)
}
