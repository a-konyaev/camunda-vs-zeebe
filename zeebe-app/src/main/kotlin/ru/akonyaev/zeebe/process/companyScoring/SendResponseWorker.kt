package ru.akonyaev.zeebe.process.companyScoring

import io.camunda.zeebe.client.api.response.ActivatedJob
import io.camunda.zeebe.client.api.worker.JobClient
import io.camunda.zeebe.spring.client.annotation.ZeebeVariable
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker
import mu.KLogging
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import ru.akonyaev.common.properties.Topics

@Component
class SendResponseWorker(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    @ZeebeWorker(type = "send-response", autoComplete = true)
    @Suppress("unused")
    fun handle(
        client: JobClient,
        job: ActivatedJob,
        @ZeebeVariable applicationId: String,
        @ZeebeVariable scoringResult: String
    ) {
        logger.debug { "handle..." }

        kafkaTemplate.send(
            Topics.COMPANY_SCORING_RESPONSE_TOPIC,
            "${applicationId}#${scoringResult}"
        )
    }

    companion object : KLogging()
}
