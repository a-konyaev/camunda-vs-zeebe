package ru.akonyaev.zeebe.interaction

import io.camunda.zeebe.spring.client.lifecycle.ZeebeClientLifecycle
import mu.KLogging
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import ru.akonyaev.common.model.ScoringResponse
import ru.akonyaev.common.process.SCORING_RESPONSE
import ru.akonyaev.common.process.SCORING_RESPONSE_MESSAGE
import ru.akonyaev.common.process.SCORING_RESULT
import ru.akonyaev.common.properties.Topics
import java.time.Duration

@Component
class ScoringResponseListener(
    private val clientLifecycle: ZeebeClientLifecycle
) {

    @KafkaListener(topics = [Topics.SCORING_RESPONSE_TOPIC])
    fun handle(data: String) {
        if (!clientLifecycle.isRunning) {
            throw IllegalStateException("Zeebe client is not started")
        }

        val response = ScoringResponse.deserialize(data)
        logger.info { "Scoring response for appId '${response.applicationId}'" }

        clientLifecycle
            .newPublishMessageCommand()
            .messageName(SCORING_RESPONSE_MESSAGE)
            .correlationKey(response.correlationId)
            .variables(
                mapOf(
                    SCORING_RESPONSE to data,
                    SCORING_RESULT to response.scoringResult.name
                )
            )
            .timeToLive(Duration.ofSeconds(60))
            .send()
            .exceptionally {
                logger.error { "Scoring response for appId '${response.applicationId}' correlation failed: $it" }
                null
            }
    }

    companion object : KLogging()
}
