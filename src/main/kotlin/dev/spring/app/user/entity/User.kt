package dev.spring.app.user.entity

import dev.spring.app.user.dto.UserDTO
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val email: String,
    val password: String
) {
    @Suppress("unused")
    constructor() : this(UUID.randomUUID(), "", "", "")

    fun toDto() = UserDTO(
        id = this.id,
        name = this.name,
        email = this.email
    )
}