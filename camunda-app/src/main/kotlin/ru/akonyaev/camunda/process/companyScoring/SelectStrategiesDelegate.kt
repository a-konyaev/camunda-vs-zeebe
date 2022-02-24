package ru.akonyaev.camunda.process.companyScoring

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import ru.akonyaev.camunda.process.strategies
import java.util.UUID

@Component
class SelectStrategiesDelegate : JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        execution.strategies = (1..3).map { UUID.randomUUID().toString() }
    }
}
