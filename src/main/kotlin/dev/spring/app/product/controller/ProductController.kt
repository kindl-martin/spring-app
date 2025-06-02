package dev.spring.app.product.controller

import dev.spring.app.product.repository.ProductRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import dev.spring.app.product.entity.Product
import org.springframework.http.ResponseEntity

@RestController
class ProductController (
    private val productRepository: ProductRepository,
) {

    @GetMapping("/product")
    fun getProducts(@RequestParam(name = "name", required = false) name: String?): ResponseEntity<Any> {
        return if (name.isNullOrBlank()) {
            ResponseEntity.badRequest().body(mapOf("error" to "You must provide a 'name' parameter"))
        } else {
            ResponseEntity.ok(productRepository.findByName(name))
        }
    }

    @GetMapping("/products")
    fun getAllProducts(): List<Product> {
        return productRepository.findAll()
    }
}