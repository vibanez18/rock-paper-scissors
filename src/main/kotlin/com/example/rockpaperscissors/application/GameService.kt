package com.example.rockpaperscissors.application

import com.example.rockpaperscissors.domain.Player
import com.example.rockpaperscissors.domain.RuleEngine
import com.example.rockpaperscissors.gateway.v1.GameDto
import org.apache.logging.log4j.kotlin.Logging
import org.springframework.stereotype.Service

@Service
class GameService: Logging {

    fun createAndExecuteGame(gameDto: GameDto): GameDto {
        val computer = Player()
        logger.debug("Computer created with name: ${computer.move} and move: ${computer.move.name}")

        val player0ne = Player(name = gameDto.playerOneName, move = gameDto.playerOneMove)
        logger.debug("PlayerOne created with name: ${player0ne.move} and move: ${player0ne.move.name}")

        val score = RuleEngine()(computer, player0ne)
        logger.info("Game Over.Computer Move:${computer.move.name}. PlayerOne Move:${player0ne.move.name} Score:${score.name}")

        return GameDto(
                playerOneName = player0ne.name,
                playerOneMove = player0ne.move,
                computerName = computer.name,
                computerMove = computer.move,
                score = score
        )
    }
}