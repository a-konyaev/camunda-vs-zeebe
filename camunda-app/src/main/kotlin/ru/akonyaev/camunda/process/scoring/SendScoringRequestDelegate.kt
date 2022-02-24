package ru.akonyaev.camunda.process.scoring

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import ru.akonyaev.camunda.interaction.ScoringClient
import ru.akonyaev.camunda.process.applicationId
import ru.akonyaev.camunda.process.clientId
import ru.akonyaev.camunda.process.correlationId
import ru.akonyaev.camunda.process.strategy
import ru.akonyaev.common.ScoringRequest
import java.util.UUID

@Component
class SendScoringRequestDelegate(
    private val scoringClient: ScoringClient
) : JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        ScoringRequest(
            applicationId = execution.processBusinessKey,
            correlationId = UUID.randomUUID().toString(),
            clientId = execution.clientId,
            strategy = execution.strategy,
        ).let {
            execution.correlationId = it.correlationId
            scoringClient.score(it)
        }
    }
}
