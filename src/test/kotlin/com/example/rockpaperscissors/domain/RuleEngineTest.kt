package com.example.rockpaperscissors.domain

import com.example.rockpaperscissors.domain.model.Move
import com.example.rockpaperscissors.domain.model.Player
import com.example.rockpaperscissors.domain.model.Score
import com.example.rockpaperscissors.domain.model.Score.DRAW
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

class RuleEngineTest {

    @Test
    fun`when computer and playerOne move paper then score is draw` () {
        val ruleEngine = RuleEngine()
        val computerMock = mock<Player> {
            on { move } doReturn Move.Paper()
        }
        val playerOneMock = mock<Player> {
            on { move } doReturn Move.Paper()
        }

        val score = ruleEngine(computerMock.move, playerOneMock.move)

        assertThat(score).isEqualTo(DRAW)
    }

    @Test
    fun`when computer and playerOne move rock then score is draw` () {
        val ruleEngine = RuleEngine()
        val computerMock = mock<Player> {
            on { move } doReturn Move.Rock()
        }
        val playerOneMock = mock<Player> {
            on { move } doReturn Move.Rock()
        }

        val score = ruleEngine(computerMock.move, playerOneMock.move)

        assertThat(score).isEqualTo(DRAW)
    }

    @Test
    fun`when computer and playerOne move scissors then score is draw` () {
        val ruleEngine = RuleEngine()
        val computerMock = mock<Player> {
            on { move } doReturn Move.Scissors()
        }
        val playerOneMock = mock<Player> {
            on { move } doReturn Move.Scissors()
        }

        val score = ruleEngine(computerMock.move, playerOneMock.move)

        assertThat(score).isEqualTo(DRAW)
    }

    @Test
    fun`when computer moves paper and playerOne moves rock then computer wins` () {
        val ruleEngine = RuleEngine()
        val computerMock = mock<Player> {
            on { move } doReturn Move.Paper()
        }
        val playerOneMock = mock<Player> {
            on { move } doReturn Move.Rock()
        }

        val score = ruleEngine(computerMock.move, playerOneMock.move)

        assertThat(score).isEqualTo(Score.COMPUTER_WIN)
    }

    @Test
    fun`when computer moves paper and playerOne moves scissors then playerOne wins` () {
        val ruleEngine = RuleEngine()
        val computerMock = mock<Player> {
            on { move } doReturn Move.Paper()
        }
        val playerOneMock = mock<Player> {
            on { move } doReturn Move.Scissors()
        }

        val score = ruleEngine(computerMock.move, playerOneMock.move)

        assertThat(score).isEqualTo(Score.PLAYER_ONE_WIN)
    }

    @Test
    fun`when computer moves rock and playerOne moves scissors then computer wins` () {
        val ruleEngine = RuleEngine()
        val computerMock = mock<Player> {
            on { move } doReturn Move.Rock()
        }
        val playerOneMock = mock<Player> {
            on { move } doReturn Move.Scissors()
        }

        val score = ruleEngine(computerMock.move, playerOneMock.move)

        assertThat(score).isEqualTo(Score.COMPUTER_WIN)
    }

    @Test
    fun`when computer moves rock and playerOne moves paper then playerOne wins` () {
        val ruleEngine = RuleEngine()
        val computerMock = mock<Player> {
            on { move } doReturn Move.Rock()
        }
        val playerOneMock = mock<Player> {
            on { move } doReturn Move.Paper()
        }

        val score = ruleEngine(computerMock.move, playerOneMock.move)

        assertThat(score).isEqualTo(Score.PLAYER_ONE_WIN)
    }

    @Test
    fun`when computer moves scissors and playerOne moves paper then computer wins` () {
        val ruleEngine = RuleEngine()
        val computerMock = mock<Player> {
            on { move } doReturn Move.Scissors()
        }
        val playerOneMock = mock<Player> {
            on { move } doReturn Move.Paper()
        }

        val score = ruleEngine(computerMock.move, playerOneMock.move)

        assertThat(score).isEqualTo(Score.COMPUTER_WIN)
    }

    @Test
    fun`when computer moves scissors and playerOne moves rock then playerOne wins` () {
        val ruleEngine = RuleEngine()
        val computerMock = mock<Player> {
            on { move } doReturn Move.Scissors()
        }
        val playerOneMock = mock<Player> {
            on { move } doReturn Move.Rock()
        }

        val score = ruleEngine(computerMock.move, playerOneMock.move)

        assertThat(score).isEqualTo(Score.PLAYER_ONE_WIN)
    }
}