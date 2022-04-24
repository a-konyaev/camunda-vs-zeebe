package ru.akonyaev.zeebe.process.scoring

import io.camunda.zeebe.client.api.response.ActivatedJob
import io.camunda.zeebe.client.api.worker.JobClient
import io.camunda.zeebe.spring.client.annotation.ZeebeVariable
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker
import mu.KLogging
import org.springframework.stereotype.Component
import ru.akonyaev.common.model.ScoringResult
import ru.akonyaev.common.process.IS_SCORING_RESULT_ERROR
import ru.akonyaev.common.process.SCORING_RESPONSE_LENGTH

@Component
class ProcessScoringResponseWorker {

    @ZeebeWorker(type = "process-scoring-response", autoComplete = true)
    @Suppress("unused")
    fun handle(
        client: JobClient,
        job: ActivatedJob,
        @ZeebeVariable scoringResult: String,
        @ZeebeVariable scoringResponse: String
    ): Map<String, Any> {
        logger.info { "handle..." }

        return mapOf(
            IS_SCORING_RESULT_ERROR to (scoringResult == ScoringResult.ERROR.name),
            SCORING_RESPONSE_LENGTH to scoringResponse.length
        )
    }

    companion object : KLogging()
}
