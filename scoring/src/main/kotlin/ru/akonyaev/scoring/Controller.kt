package ru.akonyaev.scoring

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.akonyaev.common.ScoringRequest
import javax.validation.Valid

@Tag(name = "Scoring service")
@RestController
class Controller {

    @Operation(summary = "Провести скоринг клиента")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Process started"),
            ApiResponse(responseCode = "400", description = "Bad request"),
            ApiResponse(responseCode = "500", description = "Internal error")
        ]
    )
    @PostMapping("/score", produces = [MediaType.TEXT_PLAIN_VALUE])
    fun score(@Valid @RequestBody request: ScoringRequest): String {
        return ""
    }
}
