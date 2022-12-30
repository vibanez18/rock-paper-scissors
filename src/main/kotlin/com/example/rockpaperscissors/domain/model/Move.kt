package com.example.rockpaperscissors.domain.model

sealed class Move(val nameMove: MoveType) {
    class Rock(nameMove: MoveType = MoveType.ROCK): Move(nameMove)
    class Paper(nameMove: MoveType = MoveType.PAPER): Move(nameMove)
    class Scissors(nameMove: MoveType = MoveType.SCISSORS): Move(nameMove)
}