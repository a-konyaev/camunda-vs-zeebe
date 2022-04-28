package ru.akonyaev.zeebe.process.scoringByStrategy

import io.camunda.zeebe.client.api.response.ActivatedJob
import io.camunda.zeebe.client.api.worker.JobClient
import io.camunda.zeebe.spring.client.annotation.ZeebeVariable
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker
import mu.KLogging
import org.springframework.stereotype.Component
import ru.akonyaev.common.process.RETRIES

@Component
class IncreaseRetryCounterWorker {

    @ZeebeWorker(type = "increase-retry-counter", autoComplete = true)
    @Suppress("unused")
    fun handle(
        client: JobClient,
        job: ActivatedJob,
        @ZeebeVariable retries: Int?
    ): Map<String, Any> {
        logger.debug { "handle..." }

        return mapOf(RETRIES to (retries ?: 0) + 1)
    }

    companion object : KLogging()
}
