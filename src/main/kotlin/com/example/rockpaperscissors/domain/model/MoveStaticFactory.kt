package com.example.rockpaperscissors.domain.model

class MoveStaticFactory private constructor() {
    companion object {
        fun withRandomMove(): Move = this.withMoveType(MoveType.values().random())
        fun withMoveType(moveName: MoveType): Move = when(moveName) {
            MoveType.ROCK -> Move.Rock()
            MoveType.PAPER -> Move.Paper()
            MoveType.SCISSORS -> Move.Scissors()
        }
    }
}