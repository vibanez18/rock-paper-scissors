package com.example.rockpaperscissors.application

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

@ExtendWith(MockitoExtension::class)
class GameServiceTest {

    @InjectMocks
    lateinit var gameService: GameService

    @Test
    fun `when createAndExecuteGame with valid movement then return gameDto`() {

        val gameDtoMock = mock<GameDto> {
            on { playerOneName } doReturn "playerOne"
            on { playerOneMove } doReturn "ROCK"
        }

        val (playerOneName, playerOneMove, computerName, computerMove, score) = gameService.createAndExecuteGame(gameDtoMock)

        assertThat(playerOneName).isEqualTo("playerOne")
        assertThat(playerOneMove).isEqualTo("ROCK")
        assertThat(computerName).isEqualTo("Computer")
        assertThat(computerMove).isNotEmpty
        assertThat(score).isNotNull
    }

    @Test
    fun `when createAndExecuteGame with invalid movement then thrown exception`() {

        val gameDtoMock = mock<GameDto> {
            on { playerOneName } doReturn "playerOne"
            on { playerOneMove } doReturn "FAIL"
        }

        assertThatThrownBy { gameService.createAndExecuteGame(gameDtoMock) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("No enum constant com.example.rockpaperscissors.domain.model.MoveType.FAIL")
    }
}