package com.example.rockpaperscissors

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.example.rockpaperscissors"])
class RockPaperScissorsApplication

fun main(args: Array<String>) {
	runApplication<RockPaperScissorsApplication>(*args)
}
