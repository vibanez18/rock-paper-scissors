package com.example.rockpaperscissors.infrastructure.db

import jakarta.persistence.*

@Entity
@Table(name = "historic_games")
class GameEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "player_one_name")
    val playerOneName: String,

    @Column(name = "player_one_move")
    val playerOneMove: String,

    @Column(name = "computer_name")
    val computerName: String,

    @Column(name = "computer_move")
    val computerMove: String,

    @Column(name = "score")
    val score: String
    )