package com.example.rockpaperscissors.application

import io.swagger.v3.oas.annotations.media.Schema

data class GameDto(
        @Schema(description = "Name of player one", example = "Bill")
        val playerOneName: String,
        @Schema(description = "Movement of player One", example = "ROCK")
        val playerOneMove: String,
        @Schema(description = "Name of computer", example = "Computer")
        val computerName: String? = null,
        @Schema(description = "Movement of computer", example = "PAPER")
        val computerMove: String? = null,
        @Schema(description = "Score of the game", example = "COMPUTER_WIN")
        val score: String? = null
)
