package ru.akonyaev.camunda.process

import org.camunda.bpm.engine.delegate.DelegateExecution
import ru.akonyaev.camunda.utils.VariableDelegate

const val APPLICATION_ID = "applicationId"
var DelegateExecution.applicationId: String by VariableDelegate(APPLICATION_ID)

const val CLIENT_ID = "clientId"
var DelegateExecution.clientId: String by VariableDelegate(CLIENT_ID)

const val STRATEGIES = "strategies"
var DelegateExecution.strategies: List<String> by VariableDelegate(variableName = STRATEGIES, defaultValue = listOf())

const val STRATEGY = "strategy"
var DelegateExecution.strategy: String by VariableDelegate(STRATEGY)

const val STRATEGY_INDEX = "strategyIndex"
var DelegateExecution.strategyIndex: Int by VariableDelegate(STRATEGY_INDEX, defaultValue = -1)

const val STRATEGY_SCORING_RESULT = "strategyScoringResult"
var DelegateExecution.strategyScoringResult: String by VariableDelegate(STRATEGY_SCORING_RESULT)

const val STRATEGY_SCORING_RESULTS = "strategyScoringResults"
var DelegateExecution.strategyScoringResults: List<String>
    by VariableDelegate(variableName = STRATEGY_SCORING_RESULTS, defaultValue = listOf())

const val CORRELATION_ID = "correlationId"
var DelegateExecution.correlationId: String by VariableDelegate(CORRELATION_ID)

const val SCORING_RESPONSE = "scoringResponse"
var DelegateExecution.scoringResponse: String by VariableDelegate(SCORING_RESPONSE)

const val SCORING_RESULT = "scoringResult"
var DelegateExecution.scoringResult: String by VariableDelegate(SCORING_RESULT)

const val IS_SCORING_RESULT_ERROR = "isScoringResultError"
var DelegateExecution.isScoringResultError: Boolean by VariableDelegate(IS_SCORING_RESULT_ERROR)

const val SCORING_RESPONSE_LENGTH = "scoringResponseLength"
var DelegateExecution.scoringResponseLength: Int by VariableDelegate(SCORING_RESPONSE_LENGTH)

const val RETRIES = "retries"
var DelegateExecution.retries: Int by VariableDelegate(RETRIES, defaultValue = 0)
