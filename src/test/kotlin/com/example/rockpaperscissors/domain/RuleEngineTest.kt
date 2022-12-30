package com.example.rockpaperscissors.domain

import com.example.rockpaperscissors.domain.model.Move
import com.example.rockpaperscissors.domain.model.Score.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class RuleEngineTest {

    companion object {
        @JvmStatic
        fun getDrawArguments(): List<Arguments> = listOf(
            Arguments.of(Move.Paper(), Move.Paper()),
            Arguments.of(Move.Rock(), Move.Rock()),
            Arguments.of(Move.Scissors(), Move.Scissors())
        )

        @JvmStatic
        fun getWinnerArguments(): List<Arguments> = listOf(
            Arguments.of(Move.Paper(), Move.Rock()),
            Arguments.of(Move.Rock(), Move.Scissors()),
            Arguments.of(Move.Scissors(), Move.Paper())
        )
    }

    @ParameterizedTest
    @MethodSource("getDrawArguments")
    fun`when computer and playerOne move then is draw` (computerMove: Move, playerOneMove: Move) {
        val ruleEngine = RuleEngine()

        val score = ruleEngine(computerMove, playerOneMove)

        assertThat(score).isEqualTo(DRAW)
    }

    @ParameterizedTest
    @MethodSource("getWinnerArguments")
    fun`when computer and playerOne move then playerOne wins` (computerMove: Move, playerOneMove: Move) {
        val ruleEngine = RuleEngine()

        val score = ruleEngine(computerMove, playerOneMove)

        assertThat(score).isEqualTo(COMPUTER_WIN)
    }

    @ParameterizedTest
    @MethodSource("getWinnerArguments")
    fun`when computer and playerOne move then computer wins` (playerOne: Move, computerMove: Move) {
        val ruleEngine = RuleEngine()

        val score = ruleEngine(computerMove, playerOne)

        assertThat(score).isEqualTo(PLAYER_ONE_WIN)
    }
}