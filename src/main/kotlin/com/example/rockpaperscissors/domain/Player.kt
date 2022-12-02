package com.example.rockpaperscissors.domain

data class Player(val name: String = "Super Computer",
                  val move: Move = Move.values().random())