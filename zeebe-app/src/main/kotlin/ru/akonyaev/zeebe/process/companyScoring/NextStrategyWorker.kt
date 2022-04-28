package ru.akonyaev.zeebe.process.companyScoring

import io.camunda.zeebe.client.api.response.ActivatedJob
import io.camunda.zeebe.client.api.worker.JobClient
import io.camunda.zeebe.spring.client.annotation.ZeebeVariable
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker
import mu.KLogging
import org.springframework.stereotype.Component
import ru.akonyaev.common.process.STRATEGY
import ru.akonyaev.common.process.STRATEGY_INDEX
import ru.akonyaev.common.process.STRATEGY_SCORING_RESULTS

@Component
class NextStrategyWorker {

    @ZeebeWorker(type = "next-strategy", autoComplete = true)
    @Suppress("unused")
    fun handle(
        client: JobClient,
        job: ActivatedJob,
        @ZeebeVariable strategies: List<String>,
        @ZeebeVariable strategyIndex: Int?,
        @ZeebeVariable strategyScoringResult: String?,
        @ZeebeVariable strategyScoringResults: List<String>?,
    ): Map<String, Any> {
        logger.debug { "handle..." }

        val returnMap = mutableMapOf<String, Any>()
        val index = strategyIndex ?: -1

        if (index == -1) {
            returnMap[STRATEGY_SCORING_RESULTS] = listOf<String>()
        } else {
            returnMap[STRATEGY_SCORING_RESULTS] = strategyScoringResults!! + strategyScoringResult!!
        }

        val nextIndex = index + 1
        returnMap[STRATEGY_INDEX] = nextIndex

        if (nextIndex < strategies.size) {
            returnMap[STRATEGY] = strategies[nextIndex]
        }

        return returnMap
    }

    companion object : KLogging()
}
