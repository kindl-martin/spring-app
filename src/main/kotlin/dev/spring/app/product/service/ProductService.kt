package dev.spring.app.product.service

import dev.spring.app.product.repository.ProductRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class ProductService (
    private val productRepository: ProductRepository
) {
    @Transactional
    fun getProducts() = productRepository.findAll()

    @Transactional
    fun getProductsByName(name: String) = productRepository.findByName(name)
}