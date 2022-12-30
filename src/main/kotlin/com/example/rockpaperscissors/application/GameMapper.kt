package com.example.rockpaperscissors.application

import com.example.rockpaperscissors.domain.model.Game
import com.example.rockpaperscissors.domain.model.MoveStaticFactory
import com.example.rockpaperscissors.domain.model.MoveType
import com.example.rockpaperscissors.domain.model.Score
import org.springframework.stereotype.Component

@Component
class GameMapper {
    fun fromGameDto(gameDto: GameDto): Game = Game(
        id = gameDto.id,
        playerOneName = gameDto.playerOneName,
        playerOneMove = MoveStaticFactory.withMoveType(MoveType.valueOf(gameDto.playerOneMove)),
        computerName = gameDto.computerName ?: "",
        computerMove = MoveStaticFactory.withMoveType(MoveType.valueOf(gameDto.computerMove ?: "")),
        score = Score.valueOf(gameDto.score ?: "")
    )

    fun toGameDto(game: Game): GameDto = GameDto(
        id = game.id,
        playerOneName = game.playerOneName,
        playerOneMove = game.playerOneMove.nameMove.name,
        computerName =game.computerName,
        computerMove = game.computerMove.nameMove.name,
        score = game.score.name
    )
}