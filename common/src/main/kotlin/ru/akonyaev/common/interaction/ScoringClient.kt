package ru.akonyaev.common.interaction

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import ru.akonyaev.common.model.ScoringRequest

@FeignClient(
    name = "scoring",
    url = "\${services.scoring}",
    decode404 = true
)
interface ScoringClient {
    @PostMapping(
        value = ["/score"],
    )
    fun score(request: ScoringRequest): String
}
