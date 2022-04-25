package ru.akonyaev.zeebe.controller

import io.camunda.zeebe.spring.client.ZeebeClientLifecycle
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.akonyaev.common.model.CompanyScoringRequest
import ru.akonyaev.common.process.ProcessDefinitionName
import javax.validation.Valid

@Tag(name = "Company scoring (Zeebe)")
@RestController
@RequestMapping("/process")
class ProcessController(
    private val clientLifecycle: ZeebeClientLifecycle
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
    fun startProcess(@Valid @RequestBody request: CompanyScoringRequest) {
        if (!clientLifecycle.isRunning) {
            throw IllegalStateException("Zeebe client is not started")
        }

        // TODO: check if process with the same applicationId already started
        clientLifecycle
            .newCreateInstanceCommand()
            .bpmnProcessId(ProcessDefinitionName.CompanyScoringProcess.name)
            .latestVersion()
            .variables(request.toProcessVariablesMap())
            .send()
//            .join(10, TimeUnit.SECONDS)
//            .processInstanceKey
//            .toString()
    }
}
