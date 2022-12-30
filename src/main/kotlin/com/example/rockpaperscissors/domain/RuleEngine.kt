package com.example.rockpaperscissors.domain

import com.example.rockpaperscissors.domain.model.Move
import com.example.rockpaperscissors.domain.model.Move.*
import com.example.rockpaperscissors.domain.model.Score
import com.example.rockpaperscissors.domain.model.Score.*
import org.apache.logging.log4j.kotlin.Logging

class RuleEngine: Logging {
    operator fun invoke(computerMove: Move, playerOneMove: Move): Score {
        val score = if (computerMove.javaClass == playerOneMove.javaClass) {
            logger.debug("Computer moves: ${computerMove.nameMove.name} and playerOne: ${playerOneMove.nameMove.name}.")
            DRAW
        } else {
            logger.debug("No Draw. Computer moves: ${computerMove.nameMove.name} and playerOne: ${playerOneMove.nameMove.name}.")

            when (computerMove) {
                is Rock -> if (playerOneMove is Scissors) COMPUTER_WIN else PLAYER_ONE_WIN
                is Paper -> if (playerOneMove is Rock) COMPUTER_WIN else PLAYER_ONE_WIN
                is Scissors -> if (playerOneMove is Paper) COMPUTER_WIN else PLAYER_ONE_WIN
            }
        }
        logger.debug("Score: $score")
        return score
    }
}