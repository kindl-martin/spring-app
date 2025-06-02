package dev.spring.app.category.service

import dev.spring.app.category.repository.CategoryRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CategoryService (
    private val categoryRepository: CategoryRepository
) {
    @Transactional
    fun getCategories() = categoryRepository.findAll()

    @Transactional
    fun getCategoryByName(name: String) = categoryRepository.findByName(name)
}