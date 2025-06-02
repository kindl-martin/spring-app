package dev.spring.app.user.service

import dev.spring.app.user.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class UserService (
    private val userRepository: UserRepository
) {
    @Transactional
    fun getUsers() = userRepository.findAll().map { it.toDto() }

    @Transactional
    fun getUserByEmail(name: String) = userRepository.findByEmail(name).map { it.toDto() }
}