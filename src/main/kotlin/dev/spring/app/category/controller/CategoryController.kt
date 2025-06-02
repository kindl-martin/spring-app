package dev.spring.app.category.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import dev.spring.app.category.entity.Category
import dev.spring.app.category.service.CategoryService
import org.springframework.http.ResponseEntity

@RestController
class CategoryController (
    private val categoryService: CategoryService
) {

    @GetMapping("/category")
    fun getCategory(@RequestParam(name = "name", required = false) name: String?): ResponseEntity<Any> {
        return if (name.isNullOrBlank()) {
            ResponseEntity.badRequest().body(mapOf("error" to "You must provide a 'name' parameter"))
        } else {
            ResponseEntity.ok(categoryService.getCategoryByName(name))
        }
    }

    @GetMapping("/categories")
    fun getAllCategories(): List<Category> {
        return categoryService.getCategories()
    }
}