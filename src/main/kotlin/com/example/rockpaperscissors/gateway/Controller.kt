package com.example.rockpaperscissors.gateway

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    @GetMapping("/winner/{playerTwo}")
    fun getWinner(@PathVariable("playerTwo") playerTwo: String): String {
        return playerTwo
    }
}