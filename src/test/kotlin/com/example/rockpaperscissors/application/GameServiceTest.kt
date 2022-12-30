package com.example.rockpaperscissors.application

import com.example.rockpaperscissors.domain.GameDomainRepository
import com.example.rockpaperscissors.domain.model.Game
import com.example.rockpaperscissors.domain.model.MoveStaticFactory
import com.example.rockpaperscissors.domain.model.MoveType
import com.example.rockpaperscissors.domain.model.Score
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Spy
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.*

@ExtendWith(MockitoExtension::class)
class GameServiceTest {

    @InjectMocks
    lateinit var gameService: GameService

    @Mock
    lateinit var gameDomainRepository: GameDomainRepository

    @Spy
    lateinit var gameMapper: GameMapper

    @Test
    fun `when createAndExecuteGame with valid movement then return gameDto`() {

        val gameDtoMock = mock<GameDto> {
            on { playerOneName } doReturn "playerOne"
            on { playerOneMove } doReturn "ROCK"
        }

        val gameSaved = mock<Game> {
            on { id } doReturn 1
            on { playerOneName } doReturn "playerOne"
            on { playerOneMove } doReturn MoveStaticFactory.withMoveType(MoveType.ROCK)
            on { computerName } doReturn "Computer"
            on { computerMove } doReturn MoveStaticFactory.withMoveType(MoveType.ROCK)
            on { score } doReturn Score.DRAW
        }

        whenever(gameDomainRepository.saveGame(any())).thenReturn(gameSaved)

        val (id, playerOneName, playerOneMove, computerName, computerMove, score) = gameService.createAndExecuteGame(gameDtoMock)

        assertThat(id).isEqualTo(1L)
        assertThat(playerOneName).isEqualTo("playerOne")
        assertThat(playerOneMove).isEqualTo("ROCK")
        assertThat(computerName).isEqualTo("Computer")
        assertThat(computerMove).isEqualTo("ROCK")
        assertThat(score).isEqualTo("DRAW")

        verify(gameDomainRepository).saveGame(any())
        verify(gameMapper).toGameDto(any())
        verify(gameMapper).fromGameDto(any())
    }
    @Test
    fun `when receiveHistoricGames then return all games`() {
        val historicGames = listOf(
            mock<Game> {
                on { id } doReturn 1
                on { playerOneName } doReturn "playerOne"
                on { playerOneMove } doReturn MoveStaticFactory.withMoveType(MoveType.ROCK)
                on { computerName } doReturn "Computer"
                on { computerMove } doReturn MoveStaticFactory.withMoveType(MoveType.ROCK)
                on { score } doReturn Score.DRAW
            }
        )

        whenever(gameDomainRepository.finAllGames()).thenReturn(historicGames)

        val historicGamesDto = gameService.receiveHistoricGames()

        assertThat(historicGamesDto)
            .isNotEmpty
            .hasSize(1)

        verify(gameDomainRepository).finAllGames()
        verify(gameMapper).toGameDto(any())
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