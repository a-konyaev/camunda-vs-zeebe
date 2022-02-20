package ru.akonyaev.camunda.process.companyScoring

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

@Component
class SelectStrategiesDelegate : JavaDelegate {
    override fun execute(execution: DelegateExecution?) {
        TODO("Not yet implemented")
    }
}
