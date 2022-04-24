package ru.akonyaev.zeebe.process.companyScoring

import io.camunda.zeebe.client.api.response.ActivatedJob
import io.camunda.zeebe.client.api.worker.JobClient
import io.camunda.zeebe.spring.client.annotation.ZeebeVariable
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker
import mu.KLogging
import org.springframework.stereotype.Component
import ru.akonyaev.common.interaction.StorageClient
import ru.akonyaev.common.process.CLIENT_ID

@Component
class GetApplicationDataWorker(
    private val storageClient: StorageClient
) {

    @ZeebeWorker(type = "get-application-data", autoComplete = true)
    @Suppress("unused")
    fun handle(
        client: JobClient,
        job: ActivatedJob,
        @ZeebeVariable applicationId: String
    ): Map<String, Any> {
        logger.info { "handle..." }
        val appData = storageClient.getApplication(applicationId)
        return mapOf(CLIENT_ID to appData.clientId)
    }

    companion object : KLogging()
}
