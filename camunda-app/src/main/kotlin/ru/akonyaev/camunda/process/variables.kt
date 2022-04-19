package ru.akonyaev.camunda.process

import org.camunda.bpm.engine.delegate.DelegateExecution
import ru.akonyaev.common.process.APPLICATION_ID
import ru.akonyaev.common.process.CLIENT_ID
import ru.akonyaev.common.process.CORRELATION_ID
import ru.akonyaev.common.process.IS_SCORING_RESULT_ERROR
import ru.akonyaev.common.process.RETRIES
import ru.akonyaev.common.process.SCORING_RESPONSE
import ru.akonyaev.common.process.SCORING_RESPONSE_LENGTH
import ru.akonyaev.common.process.SCORING_RESULT
import ru.akonyaev.common.process.STRATEGIES
import ru.akonyaev.common.process.STRATEGY
import ru.akonyaev.common.process.STRATEGY_INDEX
import ru.akonyaev.common.process.STRATEGY_SCORING_RESULT
import ru.akonyaev.common.process.STRATEGY_SCORING_RESULTS

var DelegateExecution.applicationId: String by VariableDelegate(APPLICATION_ID)
var DelegateExecution.clientId: String by VariableDelegate(CLIENT_ID)
var DelegateExecution.strategies: List<String> by VariableDelegate(variableName = STRATEGIES, defaultValue = listOf())
var DelegateExecution.strategy: String by VariableDelegate(STRATEGY)
var DelegateExecution.strategyIndex: Int by VariableDelegate(STRATEGY_INDEX, defaultValue = -1)
var DelegateExecution.strategyScoringResult: String by VariableDelegate(STRATEGY_SCORING_RESULT)
var DelegateExecution.strategyScoringResults: List<String>
    by VariableDelegate(variableName = STRATEGY_SCORING_RESULTS, defaultValue = listOf())
var DelegateExecution.correlationId: String by VariableDelegate(CORRELATION_ID)
var DelegateExecution.scoringResponse: String by VariableDelegate(SCORING_RESPONSE)
var DelegateExecution.scoringResult: String by VariableDelegate(SCORING_RESULT)
var DelegateExecution.isScoringResultError: Boolean by VariableDelegate(IS_SCORING_RESULT_ERROR)
var DelegateExecution.scoringResponseLength: Int by VariableDelegate(SCORING_RESPONSE_LENGTH)
var DelegateExecution.retries: Int by VariableDelegate(RETRIES, defaultValue = 0)
