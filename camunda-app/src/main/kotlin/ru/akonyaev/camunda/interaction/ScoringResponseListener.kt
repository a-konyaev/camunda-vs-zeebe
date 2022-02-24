package ru.akonyaev.camunda.interaction

import mu.KLogging
import org.camunda.bpm.engine.RuntimeService
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import ru.akonyaev.camunda.process.CORRELATION_ID
import ru.akonyaev.camunda.process.SCORING_RESPONSE
import ru.akonyaev.camunda.process.SCORING_RESULT
import ru.akonyaev.common.ScoringResponse.SCORING_RESPONSE_DELIMITER
import ru.akonyaev.common.ScoringResponse.SCORING_RESPONSE_MESSAGE
import ru.akonyaev.common.Topics

@Component
class ScoringResponseListener(
    private val runtimeService: RuntimeService
) {

    @KafkaListener(topics = [Topics.SCORING_RESPONSE_TOPIC])
    fun handle(response: String) {
        logger.info { "Scoring response: $response" }

        // response format: <applicationId>#<correlationId>#<scoringResult>#<stub data>
        val parts = response.split(SCORING_RESPONSE_DELIMITER)
        val applicationId = parts[0]
        val correlationId = parts[1]
        val scoringResult = parts[2]

        runtimeService
            .createMessageCorrelation(SCORING_RESPONSE_MESSAGE)
            .processInstanceBusinessKey(applicationId)
            .processInstanceVariableEquals(CORRELATION_ID, correlationId)
            .setVariables(
                mapOf(
                    SCORING_RESPONSE to response,
                    SCORING_RESULT to scoringResult
                )
            )
            .correlateAll()
    }

    companion object : KLogging()
}
