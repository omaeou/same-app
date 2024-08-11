package kz.sameapp.sameclient.common.config.openapi

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info

@OpenAPIDefinition(
    info = Info(
        title = "Client API",
        version = "1.0.0-SNAPSHOT",
    )
)
class OpenApiConfig