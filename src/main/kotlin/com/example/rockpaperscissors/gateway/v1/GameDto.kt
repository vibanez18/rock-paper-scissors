package com.example.rockpaperscissors.gateway.v1

import com.example.rockpaperscissors.domain.Move
import com.example.rockpaperscissors.domain.Score
import io.swagger.v3.oas.annotations.media.Schema

data class GameDto(
        @Schema(description = "Name of player one", example = "Bill")
        val playerOneName: String,
        @Schema(description = "Movement of player One", example = "ROCK")
        val playerOneMove: Move,
        @Schema(description = "Name of computer", example = "By default Super Computer")
        val computerName: String? = null,
        @Schema(description = "Movement of computer", example = "PAPER")
        val computerMove: Move? = null,
        @Schema(description = "Score of the game", example = "COMPUTER_WIN")
        val score: Score? = null
)
