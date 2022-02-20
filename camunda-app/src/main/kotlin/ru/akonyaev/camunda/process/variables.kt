package ru.akonyaev.camunda.process

import org.camunda.bpm.engine.delegate.DelegateExecution
import ru.akonyaev.camunda.utils.VariableDelegate

const val APPLICATION_ID = "applicationId"
var DelegateExecution.applicationId: String by VariableDelegate(APPLICATION_ID)
