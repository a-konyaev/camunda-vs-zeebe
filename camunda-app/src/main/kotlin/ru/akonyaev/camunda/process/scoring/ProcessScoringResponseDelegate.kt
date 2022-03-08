package ru.akonyaev.camunda.process.scoring

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import ru.akonyaev.camunda.process.isScoringResultError
import ru.akonyaev.camunda.process.scoringResponse
import ru.akonyaev.camunda.process.scoringResponseLength
import ru.akonyaev.camunda.process.scoringResult
import ru.akonyaev.common.ScoringResult

@Component
class ProcessScoringResponseDelegate : JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        execution.isScoringResultError = execution.scoringResult == ScoringResult.ERROR.name
        execution.scoringResponseLength = execution.scoringResponse.length
    }
}
