package com.example.rockpaperscissors.gateway.v1

import com.example.rockpaperscissors.application.GameService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(val gameService: GameService) {
    @PostMapping("api/v1/start")
    fun executeNewGame(@RequestBody gameDto: GameDto): GameDto =
            gameService.createAndExecuteGame(gameDto)
}