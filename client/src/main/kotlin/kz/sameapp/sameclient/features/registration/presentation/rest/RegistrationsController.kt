package kz.sameapp.sameclient.features.registration.presentation.rest

import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import kz.sameapp.sameshared.common.domain.failures.ValidationFailure
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/registrations")
@Tag(name = "Registrations Api", description = "Нужен для регистрации пользователей")
@ApiResponses(
    ApiResponse(
        responseCode = "400", description = "Invalid input parameters",
        content = [Content(schema = Schema(implementation = ValidationFailure::class))]
    )
)
class RegistrationsController