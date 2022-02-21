package ru.akonyaev.storagemock

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Application storage mock")
@RestController
class Controller() {

    @Operation(summary = "Get application data")
    @GetMapping("/{applicationId}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getApplicationData(@PathVariable applicationId: String) =
        Application(applicationId)

}
