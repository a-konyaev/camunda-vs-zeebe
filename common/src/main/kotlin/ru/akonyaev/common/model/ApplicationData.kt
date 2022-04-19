package ru.akonyaev.common.model

data class ApplicationData(
    val applicationId: String,
    val clientId: String,
    val stubData: StubData = StubData.VALUE
)
