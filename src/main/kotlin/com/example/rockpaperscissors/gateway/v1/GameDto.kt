package com.example.rockpaperscissors.gateway.v1

import com.example.rockpaperscissors.domain.Move
import com.example.rockpaperscissors.domain.Score

data class GameDto(
        val playerOneName: String,
        val playerOneMove: Move,
        val computerName: String? = null,
        val computerMove: Move? = null,
        val score: Score? = null
)
