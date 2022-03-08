package ru.akonyaev.camunda.process.scoringByStrategy

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import ru.akonyaev.camunda.process.retries

@Component
class IncreaseRetryCounterDelegate : JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        execution.retries = execution.retries + 1
    }
}
