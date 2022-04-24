package ru.akonyaev.zeebe.process.scoring

import io.camunda.zeebe.client.api.response.ActivatedJob
import io.camunda.zeebe.client.api.worker.JobClient
import io.camunda.zeebe.spring.client.annotation.ZeebeVariable
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker
import mu.KLogging
import org.springframework.stereotype.Component
import ru.akonyaev.common.interaction.ScoringClient
import ru.akonyaev.common.model.ScoringRequest
import ru.akonyaev.common.process.CORRELATION_ID
import java.util.UUID

@Component
class SendScoringRequestWorker(
    private val scoringClient: ScoringClient
) {

    @ZeebeWorker(type = "send-scoring-request", autoComplete = true)
    @Suppress("unused")
    fun handle(
        client: JobClient,
        job: ActivatedJob,
        @ZeebeVariable applicationId: String,
        @ZeebeVariable clientId: String,
        @ZeebeVariable strategy: String
    ): Map<String, Any> {
        logger.info { "handle..." }

        val request = ScoringRequest(
            applicationId = applicationId,
            correlationId = UUID.randomUUID().toString(),
            clientId = clientId,
            strategy = strategy
        )
        scoringClient.score(request)

        return mapOf(CORRELATION_ID to request.correlationId)
    }

    companion object : KLogging()
}
