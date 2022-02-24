package ru.akonyaev.common

data class ScoringRequest(
    val applicationId: String,
    val correlationId: String,
    val clientId: String,
    val strategy: String
)
