package ru.akonyaev.camunda.process.companyScoring

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component
import ru.akonyaev.camunda.client.StorageClient

@Component
class GetApplicationDataDelegate(
    val storageClient: StorageClient
) : JavaDelegate {

    override fun execute(execution: DelegateExecution) {
        storageClient.getApplication("111")
    }
}
