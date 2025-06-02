package dev.spring.app.product.entity

import dev.spring.app.category.entity.Category
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

import java.util.*

@Entity
@Table(name = "products")
data class Product(
    @Id
    @GeneratedValue
    val id: UUID = UUID.randomUUID(),
    val name: String,
    @Column(precision = 10, scale = 2)
    val price: BigDecimal,
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    val category: Category? = null
) {
    constructor() : this(UUID.randomUUID(), "", BigDecimal.ZERO, LocalDateTime.now(), null)
}
