package ru.akonyaev.common

data class ApplicationData(
    val applicationId: String,
    val clientId: String,

    val stubData: StubData = StubData.VALUE
)
