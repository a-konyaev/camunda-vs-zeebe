package ru.akonyaev.camunda.process.companyScoring

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import ru.akonyaev.camunda.process.strategies
import ru.akonyaev.camunda.process.strategy
import ru.akonyaev.camunda.process.strategyIndex
import ru.akonyaev.camunda.process.strategyScoringResult
import ru.akonyaev.camunda.process.strategyScoringResults

@Component
class NextStrategyDelegate : JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        val index = execution.strategyIndex

        if (index > -1) {
            execution.strategyScoringResults += execution.strategyScoringResult
        }

        val nextIndex = index + 1
        execution.strategyIndex = nextIndex

        val strategies = execution.strategies
        if (nextIndex < strategies.size) {
            execution.strategy = strategies[nextIndex]
        }
    }
}
