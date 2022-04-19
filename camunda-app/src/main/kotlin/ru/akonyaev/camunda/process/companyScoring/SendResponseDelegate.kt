package ru.akonyaev.camunda.process.companyScoring

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import ru.akonyaev.camunda.process.applicationId
import ru.akonyaev.camunda.process.scoringResult
import ru.akonyaev.common.properties.Topics

@Component
class SendResponseDelegate(
    private val kafkaTemplate: KafkaTemplate<String, String>
) : JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        kafkaTemplate.send(
            Topics.COMPANY_SCORING_RESPONSE_TOPIC,
            "${execution.applicationId}#${execution.scoringResult}"
        )
    }
}
