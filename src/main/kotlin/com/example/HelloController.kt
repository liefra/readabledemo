package com.example

import com.fasterxml.jackson.annotation.JsonFormat
import io.micronaut.context.annotation.Value
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.serde.annotation.Serdeable
import org.slf4j.LoggerFactory
import java.time.LocalDate
import java.time.LocalDateTime
import io.micronaut.core.io.Readable

@Controller("/")
class HelloController(
    @Value("\${app.filepath}") private val filepath: Readable,
) {
    private val log = LoggerFactory.getLogger(javaClass)

    @Get
    fun say(): Person {
        log.info("Processing ${filepath.name} at ${LocalDateTime.now()}")
        return Person(LocalDate.of(1999, 1, 1), "Ted")
    }
}

@Serdeable
data class Person(
    @field:JsonFormat(pattern = "yyyy-MM-dd")
    val birthday: LocalDate,
    val name: String,
)
