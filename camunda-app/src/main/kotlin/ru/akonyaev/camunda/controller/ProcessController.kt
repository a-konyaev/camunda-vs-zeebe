package ru.akonyaev.camunda.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import mu.KLogging
import org.camunda.bpm.engine.RuntimeService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.akonyaev.camunda.model.CompanyScoringRequest
import ru.akonyaev.camunda.process.ProcessDefinitionName
import javax.validation.Valid

@Tag(name = "Company scoring (Camunda platform)")
@RestController
@RequestMapping("/process")
class ProcessController(
    private val runtimeService: RuntimeService
) {

    @Operation(summary = "Start the process")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Process started"),
            ApiResponse(responseCode = "400", description = "Bad request"),
            ApiResponse(responseCode = "500", description = "Internal error")
        ]
    )
    @PostMapping("/start", produces = [MediaType.TEXT_PLAIN_VALUE])
    fun startProcess(@Valid @RequestBody request: CompanyScoringRequest): String {
        // TODO: check if process with the same applicationId already started
        val id = runtimeService.startProcessInstanceByKey(
            ProcessDefinitionName.CompanyScoringProcess.name,
            request.applicationId,
            request.toProcessVariablesMap()
        ).id
        logger.info {
            "New process instance with id = $id started on request: $request"
        }
        return id
    }

    companion object : KLogging()
}
