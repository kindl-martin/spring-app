package dev.spring.app.product.repository

import dev.spring.app.product.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ProductRepository : JpaRepository<Product, UUID> {
    fun findByName(name: String): List<Product>
}

