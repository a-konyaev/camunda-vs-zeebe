package ru.akonyaev.camunda.process

import ru.akonyaev.camunda.utils.ProcessDefinitionKey

enum class ProcessDefinitionName : ProcessDefinitionKey {
    CompanyScoringProcess,
    ScoringByStrategyProcess,
    ScoringProcess
}
