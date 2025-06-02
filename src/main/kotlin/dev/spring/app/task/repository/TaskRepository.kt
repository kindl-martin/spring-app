package dev.spring.app.task.repository

import dev.spring.app.task.entity.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TaskRepository : JpaRepository<Task, UUID> {
    fun findByName(name: String): List<Task>
    fun findByDeletedAtIsNull(): List<Task>
}

