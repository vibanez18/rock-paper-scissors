package com.example.rockpaperscissors.domain.model

import com.example.rockpaperscissors.domain.model.MoveType.*

class MoveStaticFactory private constructor() {
    companion object {
        fun withRandomMove(): Move = this.withMoveType(values().random())
        fun withMoveType(moveName: MoveType): Move = when(moveName) {
            ROCK -> Move.Rock()
            PAPER -> Move.Paper()
            SCISSORS -> Move.Scissors()
        }
    }
}