package ru.akonyaev.common.model

data class ScoringRequest(
    val applicationId: String,
    val correlationId: String,
    val clientId: String,
    val strategy: String
)
