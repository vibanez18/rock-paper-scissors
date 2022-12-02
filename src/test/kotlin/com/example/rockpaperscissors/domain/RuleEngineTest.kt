package com.example.rockpaperscissors.domain

import com.example.rockpaperscissors.domain.Score.DRAW
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

class RuleEngineTest {

    @Test
    fun`when computer and playerOne move paper then score is draw` () {
        val ruleEngine = RuleEngine()
        val computerMock = mock<Player> {
            on { move } doReturn Move.PAPER
        }
        val player1Mock = mock<Player> {
            on { move } doReturn Move.PAPER
        }

        val score = ruleEngine(computerMock, player1Mock)

        assertThat(score).isEqualTo(DRAW)
    }

    @Test
    fun`when computer and playerOne move rock then score is draw` () {
        val ruleEngine = RuleEngine()
        val computerMock = mock<Player> {
            on { move } doReturn Move.ROCK
        }
        val player1Mock = mock<Player> {
            on { move } doReturn Move.ROCK
        }

        val score = ruleEngine(computerMock, player1Mock)

        assertThat(score).isEqualTo(DRAW)
    }

    @Test
    fun`when computer and playerOne move scissors then score is draw` () {
        val ruleEngine = RuleEngine()
        val computerMock = mock<Player> {
            on { move } doReturn Move.SCISSORS
        }
        val player1Mock = mock<Player> {
            on { move } doReturn Move.SCISSORS
        }

        val score = ruleEngine(computerMock, player1Mock)

        assertThat(score).isEqualTo(DRAW)
    }

    @Test
    fun`when computer moves paper and playerOne moves rock then computer wins` () {
        val ruleEngine = RuleEngine()
        val computerMock = mock<Player> {
            on { move } doReturn Move.PAPER
        }
        val player1Mock = mock<Player> {
            on { move } doReturn Move.ROCK
        }

        val score = ruleEngine(computerMock, player1Mock)

        assertThat(score).isEqualTo(Score.COMPUTER_WIN)
    }

    @Test
    fun`when computer moves paper and playerOne moves scissors then playerOne wins` () {
        val ruleEngine = RuleEngine()
        val computerMock = mock<Player> {
            on { move } doReturn Move.PAPER
        }
        val player1Mock = mock<Player> {
            on { move } doReturn Move.SCISSORS
        }

        val score = ruleEngine(computerMock, player1Mock)

        assertThat(score).isEqualTo(Score.PLAYER_ONE_WIN)
    }

    @Test
    fun`when computer moves rock and playerOne moves scissors then computer wins` () {
        val ruleEngine = RuleEngine()
        val computerMock = mock<Player> {
            on { move } doReturn Move.ROCK
        }
        val player1Mock = mock<Player> {
            on { move } doReturn Move.SCISSORS
        }

        val score = ruleEngine(computerMock, player1Mock)

        assertThat(score).isEqualTo(Score.COMPUTER_WIN)
    }

    @Test
    fun`when computer moves rock and playerOne moves paper then playerOne wins` () {
        val ruleEngine = RuleEngine()
        val computerMock = mock<Player> {
            on { move } doReturn Move.ROCK
        }
        val player1Mock = mock<Player> {
            on { move } doReturn Move.PAPER
        }

        val score = ruleEngine(computerMock, player1Mock)

        assertThat(score).isEqualTo(Score.PLAYER_ONE_WIN)
    }

    @Test
    fun`when computer moves scissors and playerOne moves paper then computer wins` () {
        val ruleEngine = RuleEngine()
        val computerMock = mock<Player> {
            on { move } doReturn Move.SCISSORS
        }
        val player1Mock = mock<Player> {
            on { move } doReturn Move.PAPER
        }

        val score = ruleEngine(computerMock, player1Mock)

        assertThat(score).isEqualTo(Score.COMPUTER_WIN)
    }

    @Test
    fun`when computer moves scissors and playerOne moves rock then playerOne wins` () {
        val ruleEngine = RuleEngine()
        val computerMock = mock<Player> {
            on { move } doReturn Move.SCISSORS
        }
        val player1Mock = mock<Player> {
            on { move } doReturn Move.ROCK
        }

        val score = ruleEngine(computerMock, player1Mock)

        assertThat(score).isEqualTo(Score.PLAYER_ONE_WIN)
    }
}