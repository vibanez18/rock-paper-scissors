package com.example.rockpaperscissors.application

import com.example.rockpaperscissors.domain.GameDomainRepository
import com.example.rockpaperscissors.domain.model.Player
import com.example.rockpaperscissors.domain.RuleEngine
import com.example.rockpaperscissors.domain.model.MoveStaticFactory
import com.example.rockpaperscissors.domain.model.MoveType
import com.example.rockpaperscissors.domain.model.Score
import org.apache.logging.log4j.kotlin.Logging
import org.springframework.stereotype.Service

@Service
class GameService(
    val gameDomainRepository: GameDomainRepository,
    val gameMapper: GameMapper
): Logging {

    fun createAndExecuteGame(gameDto: GameDto): GameDto {
        val computer = Player(
            move = MoveStaticFactory.withRandomMove()
        )
        logger.debug("Computer created with name: ${computer.name} and move: ${computer.move.nameMove}")

        val player0ne = Player(
            name = gameDto.playerOneName,
            move = MoveStaticFactory.withMoveType(MoveType.valueOf(gameDto.playerOneMove))
        )
        logger.debug("PlayerOne created with name: ${player0ne.name} and move: ${player0ne.move.nameMove}")

        val score = RuleEngine()(computer.move, player0ne.move)
        logger.info("Game Over.Computer Move:${computer.move.nameMove}. PlayerOne Move:${player0ne.move.nameMove} Score:${score.name}")

        return saveGame(player0ne, computer, score)
    }

    fun receiveHistoricGames(): List<GameDto> = gameDomainRepository.finAllGames()
        .map { gameMapper.toGameDto(it) }
    private fun saveGame(
        player0ne: Player,
        computer: Player,
        score: Score
    ): GameDto = gameMapper.toGameDto(gameDomainRepository.saveGame(gameMapper.fromGameDto(GameDto(
        playerOneName = player0ne.name,
        playerOneMove = player0ne.move.nameMove.name,
        computerName = computer.name,
        computerMove = computer.move.nameMove.name,
        score = score.name
    ))))
}