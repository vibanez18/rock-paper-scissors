package com.example.rockpaperscissors.gateway.v1

import com.example.rockpaperscissors.application.GameDto
import com.example.rockpaperscissors.application.GameService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("http://localhost:4200")
class Controller(val gameService: GameService) {
    @PostMapping("api/v1/start")
    @Operation(summary="Execute a new game", description = "Returns all the data of the game")
    @ApiResponses(value = [
        ApiResponse(responseCode="200", description = "Successful Operation",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = GameDto::class))])
    ])
    fun executeNewGame(@RequestBody gameDto: GameDto): GameDto =
            gameService.createAndExecuteGame(gameDto)

    @GetMapping("api/v1/historic")
    @Operation(summary="Receive the history of the games", description = "Receive the history of the games")
    @ApiResponses(value = [
        ApiResponse(responseCode="200", description = "Successful Operation",
            content = [Content(mediaType = "application/json", schema = Schema(implementation = List::class))])
    ])
    fun getHistoricGames(): List<GameDto> = gameService.receiveHistoricGames()
}