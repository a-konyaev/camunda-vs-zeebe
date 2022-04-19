package ru.akonyaev.camunda.process.companyScoring

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import ru.akonyaev.common.interaction.StorageClient
import ru.akonyaev.camunda.process.applicationId
import ru.akonyaev.camunda.process.clientId

@Component
class GetApplicationDataDelegate(
    private val storageClient: StorageClient
) : JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        storageClient.getApplication(execution.applicationId).let {
            execution.clientId = it.clientId
        }
    }
}
