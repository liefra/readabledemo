package com.example

import io.micronaut.context.annotation.Value
import io.micronaut.core.io.Readable
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import org.slf4j.LoggerFactory
import java.time.LocalDateTime

@Controller("/")
class ReadableDemoController(
    @Value("\${app.filepath}") private val csvFileReadable: Readable,
) {
    private val log = LoggerFactory.getLogger(javaClass)

    @Get
    fun say(): Boolean {
        log.info("Processing ${csvFileReadable.name} at ${LocalDateTime.now()}")
        return csvFileReadable.exists()
    }
}
