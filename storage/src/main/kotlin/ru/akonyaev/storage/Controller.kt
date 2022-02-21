package ru.akonyaev.storage

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import ru.akonyaev.common.model.ApplicationData

@Tag(name = "Application storage")
@RestController
class Controller {

    @Operation(summary = "Get application data")
    @GetMapping("/{applicationId}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getApplicationData(@PathVariable applicationId: String) =
        ApplicationData(applicationId)

}
