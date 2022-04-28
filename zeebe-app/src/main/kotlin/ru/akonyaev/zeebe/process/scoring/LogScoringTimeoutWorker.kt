package ru.akonyaev.zeebe.process.scoring

import io.camunda.zeebe.client.api.response.ActivatedJob
import io.camunda.zeebe.client.api.worker.JobClient
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker
import mu.KLogging
import org.springframework.stereotype.Component

@Component
class LogScoringTimeoutWorker {

    @ZeebeWorker(type = "log-scoring-timeout", autoComplete = true)
    @Suppress("unused")
    fun handle(
        client: JobClient,
        job: ActivatedJob
    ) {
        logger.info { "Scoring timeout" }
    }

    companion object : KLogging()
}
