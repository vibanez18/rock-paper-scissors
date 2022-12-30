package com.example.rockpaperscissors.infrastructure.db

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GameJpaRepository: JpaRepository<GameEntity, Long>