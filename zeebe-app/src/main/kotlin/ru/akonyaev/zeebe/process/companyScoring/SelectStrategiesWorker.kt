package ru.akonyaev.zeebe.process.companyScoring

import io.camunda.zeebe.client.api.response.ActivatedJob
import io.camunda.zeebe.client.api.worker.JobClient
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker
import mu.KLogging
import org.springframework.stereotype.Component
import ru.akonyaev.common.process.STRATEGIES
import java.util.UUID

@Component
class SelectStrategiesWorker {

    @ZeebeWorker(type = "select-strategies", autoComplete = true)
    @Suppress("unused")
    fun handle(
        client: JobClient,
        job: ActivatedJob
    ): Map<String, Any> {
        logger.debug { "handle..." }

        val strategies = (1..STRATEGIES_COUNT).map { UUID.randomUUID().toString() }
        return mapOf(STRATEGIES to strategies)
    }

    companion object : KLogging() {
        const val STRATEGIES_COUNT = 3
    }
}
