package ru.akonyaev.scoring

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.akonyaev.common.ScoringRequest
import ru.akonyaev.common.ScoringResponse
import ru.akonyaev.common.ScoringResult
import ru.akonyaev.common.Topics
import javax.validation.Valid
import kotlin.random.Random

@Tag(name = "Scoring service")
@RestController
class Controller(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    @Operation(summary = "Провести скоринг клиента")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Process started"),
            ApiResponse(responseCode = "400", description = "Bad request"),
            ApiResponse(responseCode = "500", description = "Internal error")
        ]
    )
    @PostMapping("/score", produces = [MediaType.TEXT_PLAIN_VALUE])
    fun score(@Valid @RequestBody request: ScoringRequest) {
        if (ignoreRequest()) return

        val response = ScoringResponse(
            applicationId = request.applicationId,
            correlationId = request.correlationId,
            scoringResult = getResult()
        )
        kafkaTemplate.send(Topics.SCORING_RESPONSE_TOPIC, response.serialize())
    }

    private fun ignoreRequest() = Random.nextInt(1, 100) == 1

    private fun getResult() = if (Random.nextInt(1, 10) == 1) ScoringResult.ERROR else ScoringResult.OK
}
