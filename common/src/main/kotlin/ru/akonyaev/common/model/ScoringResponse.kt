package ru.akonyaev.common.model

data class ScoringResponse(
    val applicationId: String,
    val correlationId: String,
    val scoringResult: ScoringResult
) {

    fun serialize(): String {
        // format: <applicationId>#<correlationId>#<scoringResult>#<stub data...>
        return "$applicationId$SCORING_RESPONSE_DELIMITER" +
            "$correlationId$SCORING_RESPONSE_DELIMITER" +
            "$scoringResult$SCORING_RESPONSE_DELIMITER" + StubData.VALUE_STR
    }

    companion object {
        private const val SCORING_RESPONSE_DELIMITER = "#"

        fun deserialize(data: String): ScoringResponse {
            val parts = data.split(SCORING_RESPONSE_DELIMITER)
            return ScoringResponse(
                applicationId = parts[0],
                correlationId = parts[1],
                scoringResult = ScoringResult.valueOf(parts[2])
            )
        }
    }
}
