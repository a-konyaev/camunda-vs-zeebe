package ru.akonyaev.common.model

import io.swagger.v3.oas.annotations.media.Schema
import ru.akonyaev.common.process.APPLICATION_ID
import javax.validation.constraints.NotBlank

@Schema
data class CompanyScoringRequest(
    @Schema(name = "Application ID", required = true)
    @field:NotBlank
    val applicationId: String
) {

    fun toProcessVariablesMap() = mapOf(
        APPLICATION_ID to applicationId
    )
}
