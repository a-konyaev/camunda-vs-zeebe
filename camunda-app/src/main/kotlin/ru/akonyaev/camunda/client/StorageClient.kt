package ru.akonyaev.camunda.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import ru.akonyaev.common.model.ApplicationData

@FeignClient(
    name = "storage",
    url = "\${services.storage}",
    decode404 = true
)
interface StorageClient {
    @GetMapping(
        value = ["/{applicationId}"]
    )
    fun getApplication(@PathVariable applicationId: String): ApplicationData
}
