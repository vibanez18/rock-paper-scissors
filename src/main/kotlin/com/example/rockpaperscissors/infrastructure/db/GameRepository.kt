package com.example.rockpaperscissors.infrastructure.db

import com.example.rockpaperscissors.domain.GameDomainRepository
import com.example.rockpaperscissors.domain.model.Game
import org.springframework.stereotype.Component

@Component
class GameRepository(
    val gameJpaRepository: GameJpaRepository,
    val gameEntityMapper: GameEntityMapper
): GameDomainRepository {
    override fun finAllGames(): List<Game> = gameJpaRepository.findAll()
        .map { gameEntityMapper.fromGameEntity(it) }

    override fun saveGame(game: Game): Game = gameEntityMapper.fromGameEntity(gameJpaRepository.save(gameEntityMapper.toGameEntity(game)))
}