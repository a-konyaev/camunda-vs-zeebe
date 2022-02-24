package ru.akonyaev.common

import java.util.UUID

data class StubData(
    val bool1: Boolean,
    val bool2: Boolean,
    val bool3: Boolean,
    val bool4: Boolean,
    val bool5: Boolean,
    val string1: String,
    val string2: String,
    val string3: String,
    val string4: String,
    val string5: String,
    val double1: Double,
    val double2: Double,
    val double3: Double,
    val double4: Double,
    val double5: Double,
    val list1: List<String>,
    val list2: List<String>,
    val list3: List<String>,
    val list4: List<String>,
    val list5: List<String>,
) {
    companion object {
        private val strList = (1..10).map { UUID.randomUUID().toString() }
        val VALUE = StubData(
            bool1 = true,
            bool2 = false,
            bool3 = true,
            bool4 = false,
            bool5 = true,
            string1 = "some-string-data-01234567890-qwertyuioplkjhgfdsazxcvbnm",
            string2 = "some-string-data-01234567890-qwertyuioplkjhgfdsazxcvbnm",
            string3 = "some-string-data-01234567890-qwertyuioplkjhgfdsazxcvbnm",
            string4 = "some-string-data-01234567890-qwertyuioplkjhgfdsazxcvbnm",
            string5 = "some-string-data-01234567890-qwertyuioplkjhgfdsazxcvbnm",
            double1 = 123456789.987654321,
            double2 = 123456789.987654321,
            double3 = 123456789.987654321,
            double4 = 123456789.987654321,
            double5 = 123456789.987654321,
            list1 = strList,
            list2 = strList,
            list3 = strList,
            list4 = strList,
            list5 = strList
        )
    }
}
