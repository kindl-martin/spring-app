package dev.spring.app.category.entity

import jakarta.persistence.*

import java.util.*

@Entity
@Table(name = "categories")
data class Category(
    @Id
    @GeneratedValue
    val id: UUID = UUID.randomUUID(),
    val name: String,
) {
    constructor() : this(UUID.randomUUID(), "")
}
