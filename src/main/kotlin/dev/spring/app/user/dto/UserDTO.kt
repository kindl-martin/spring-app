package dev.spring.app.user.dto

import java.util.UUID

data class UserDTO(
    val id: UUID,
    val name: String,
    val email: String
)