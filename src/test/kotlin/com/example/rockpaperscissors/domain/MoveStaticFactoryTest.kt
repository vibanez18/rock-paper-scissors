package com.example.rockpaperscissors.domain

import com.example.rockpaperscissors.domain.model.Move
import com.example.rockpaperscissors.domain.model.MoveStaticFactory
import com.example.rockpaperscissors.domain.model.MoveType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class MoveStaticFactoryTest {

    @Test
    fun `when withRandomMove then return random Move`() {
        val randomMove = MoveStaticFactory.withRandomMove()

        assertThat(randomMove)
            .isNotNull
            .isInstanceOf(Move::class.java)
    }

    @ParameterizedTest
    @EnumSource(value = MoveType::class, names = ["ROCK", "PAPER", "SCISSORS"])
    fun `when withMoveType then return Move by name`(moveType: MoveType) {
        val moveWithMoveType = MoveStaticFactory.withMoveType(moveType)

        assertThat(moveWithMoveType)
            .isInstanceOf(Move::class.java)

        assertThat(moveWithMoveType.nameMove)
            .isEqualTo(moveType)
    }
}