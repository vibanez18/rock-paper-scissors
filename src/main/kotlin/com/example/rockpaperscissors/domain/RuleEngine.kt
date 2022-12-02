package com.example.rockpaperscissors.domain

import com.example.rockpaperscissors.domain.Move.ROCK
import com.example.rockpaperscissors.domain.Move.PAPER
import com.example.rockpaperscissors.domain.Move.SCISSORS

class RuleEngine {
    operator fun invoke(computer: Player, playerOne: Player): Score {
        return if(computer.move == playerOne.move) {
            return Score.DRAW
        } else {
            when(computer.move) {
                ROCK -> if (playerOne.move == SCISSORS) return Score.COMPUTER_WIN else Score.PLAYER_ONE_WIN
                PAPER -> if (playerOne.move == ROCK) return Score.COMPUTER_WIN else Score.PLAYER_ONE_WIN
                SCISSORS -> if (playerOne.move == PAPER) return Score.COMPUTER_WIN else Score.PLAYER_ONE_WIN
            }
        }
    }
}