package kz.sameapp.sameclient.common.config.handlers

import com.fasterxml.jackson.databind.ObjectMapper
import kotlinx.coroutines.reactor.mono
import kz.sameapp.sameshared.common.domain.failures.ServiceUnavailableFailure
import org.slf4j.Logger
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Component
class GlobalExceptionHandler (
    private val logger: Logger,
    private val objectMapper: ObjectMapper
) : ErrorWebExceptionHandler {
    override fun handle(exchanges: ServerWebExchange, ex: Throwable): Mono<Void> {
        logger.error("Unhandled global Exception", ex)
        val buffer = mono {
            objectMapper.writeValueAsBytes(ServiceUnavailableFailure(message = ex.localizedMessage))
        }.map {
            exchanges.response.bufferFactory().wrap(it)
        }
        exchanges.response.headers.contentType = MediaType.APPLICATION_JSON
        exchanges.response.statusCode = HttpStatus.SERVICE_UNAVAILABLE
        return exchanges.response.writeWith(buffer)
    }
}