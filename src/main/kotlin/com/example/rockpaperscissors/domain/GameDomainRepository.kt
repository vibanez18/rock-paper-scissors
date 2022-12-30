package com.example.rockpaperscissors.domain

import com.example.rockpaperscissors.domain.model.Game

interface GameDomainRepository {
    fun finAllGames(): List<Game>
    fun saveGame(game: Game): Game
}