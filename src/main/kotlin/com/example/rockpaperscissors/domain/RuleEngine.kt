package com.example.rockpaperscissors.domain

import com.example.rockpaperscissors.domain.Move.ROCK
import com.example.rockpaperscissors.domain.Move.PAPER
import com.example.rockpaperscissors.domain.Move.SCISSORS
import com.example.rockpaperscissors.domain.Score.DRAW
import com.example.rockpaperscissors.domain.Score.COMPUTER_WIN
import com.example.rockpaperscissors.domain.Score.PLAYER_ONE_WIN
import org.apache.logging.log4j.kotlin.Logging

class RuleEngine: Logging {
    operator fun invoke(computer: Player, playerOne: Player): Score {
        return if(computer.move == playerOne.move) {
            logger.info("Computer moves: ${computer.move} and playerOne: ${playerOne.move}. Score was Draw")
            return DRAW
        } else {
            logger.info("No Draw. Computer moves: ${computer.move} and playerOne: ${playerOne.move}.")
            when(computer.move) {
                ROCK -> if (playerOne.move == SCISSORS) return COMPUTER_WIN else PLAYER_ONE_WIN
                PAPER -> if (playerOne.move == ROCK) return COMPUTER_WIN else PLAYER_ONE_WIN
                SCISSORS -> if (playerOne.move == PAPER) return COMPUTER_WIN else PLAYER_ONE_WIN
            }
        }
    }
}