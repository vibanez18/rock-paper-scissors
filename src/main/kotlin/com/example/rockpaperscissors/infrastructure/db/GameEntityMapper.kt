package com.example.rockpaperscissors.infrastructure.db

import com.example.rockpaperscissors.domain.model.Game
import com.example.rockpaperscissors.domain.model.MoveStaticFactory
import com.example.rockpaperscissors.domain.model.MoveType
import com.example.rockpaperscissors.domain.model.Score
import org.springframework.stereotype.Component

@Component
class GameEntityMapper {

    fun fromGameEntity(gameEntity: GameEntity): Game = Game(
        id = gameEntity.id,
        playerOneName = gameEntity.playerOneName,
        playerOneMove = MoveStaticFactory.withMoveType(MoveType.valueOf(gameEntity.playerOneMove)),
        computerName = gameEntity.computerName,
        computerMove = MoveStaticFactory.withMoveType(MoveType.valueOf(gameEntity.computerMove)),
        score = Score.valueOf(gameEntity.score)
    )

    fun toGameEntity(game: Game): GameEntity = GameEntity(
        id = game.id,
        playerOneName = game.playerOneName,
        playerOneMove = game.playerOneMove.nameMove.name,
        computerName = game.computerName,
        computerMove = game.computerMove.nameMove.name,
        score = game.score.name
    )
}