package com.example.rockpaperscissors.gateway.v1

import org.apache.logging.log4j.kotlin.Logging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ControllerAdvice: Logging {

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleInvalidMovement(exception: IllegalArgumentException): ResponseEntity<Any> {
        logger.error("Player one try invalid movement")
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }
}