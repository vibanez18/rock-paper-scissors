package com.example.rockpaperscissors.gateway.v1

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @LocalServerPort
    var port: Int = 0

    @Test
    fun `when call start endpoint with valid value then return ok`() {
        mockMvc.post("http://localhost:${port}/api/v1/start") {
            contentType = MediaType.APPLICATION_JSON
            content = createPlayerOneWithRockMove()
        }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
            content { json(createPlayerOneWithRockMove(), false) }
        }
    }

    @Test
    fun `when call start endpoint with invalid value then return 400`() {
        mockMvc.post("http://localhost:${port}/api/v1/start") {
            contentType = MediaType.APPLICATION_JSON
            content = createPlayerOneWithInvalidMove()
        }.andExpect { status { isBadRequest() } }
    }

    @Test
    fun `when call historic endpoint then return 200`() {
        mockMvc.get("http://localhost:${port}/api/v1/historic") {
            contentType = MediaType.APPLICATION_JSON
        }.andExpect { status { isOk() } }
    }

    private fun createPlayerOneWithRockMove() = """
        {
        	"playerOneName": "PlayerOne",
        	"playerOneMove": "ROCK"
        }
    """.trimIndent()

    private fun createPlayerOneWithInvalidMove() = """
        {
        	"playerOneName": "PlayerOne",
        	"playerOneMove": "FAIL"
        }
    """.trimIndent()
}