package dev.spring.app.task.service

import dev.spring.app.task.repository.TaskRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class TaskService (
    private val taskRepository: TaskRepository
) {
    @Transactional
    fun getTasks() = taskRepository.findByDeletedAtIsNull()

    @Transactional
    fun getTaskByName(name: String) = taskRepository.findByName(name)
}