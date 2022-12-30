package com.example.rockpaperscissors.domain.model

data class Game (
    val id: Long? = null,
    val playerOneName: String,
    val playerOneMove: Move,
    val computerName: String,
    val computerMove: Move,
    val score: Score)