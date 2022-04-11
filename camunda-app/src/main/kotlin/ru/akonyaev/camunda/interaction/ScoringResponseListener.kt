package ru.akonyaev.camunda.interaction

import mu.KLogging
import org.camunda.bpm.engine.RuntimeService
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import ru.akonyaev.camunda.process.CORRELATION_ID
import ru.akonyaev.camunda.process.SCORING_RESPONSE
import ru.akonyaev.camunda.process.SCORING_RESPONSE_MESSAGE
import ru.akonyaev.camunda.process.SCORING_RESULT
import ru.akonyaev.common.ScoringResponse
import ru.akonyaev.common.Topics

@Component
class ScoringResponseListener(
    private val runtimeService: RuntimeService
) {

    @KafkaListener(topics = [Topics.SCORING_RESPONSE_TOPIC])
    fun handle(data: String) {
        val response = ScoringResponse.deserialize(data)
        logger.info { "Scoring response for appId: ${response.applicationId}" }

        runtimeService
            .createMessageCorrelation(SCORING_RESPONSE_MESSAGE)
            .processInstanceBusinessKey(response.applicationId)
            .processInstanceVariableEquals(CORRELATION_ID, response.correlationId)
            .setVariables(
                mapOf(
                    SCORING_RESPONSE to data,
                    SCORING_RESULT to response.scoringResult.name
                )
            )
            .correlateAll()
    }

    companion object : KLogging()
}
