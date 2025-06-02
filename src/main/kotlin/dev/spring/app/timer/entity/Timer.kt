package dev.spring.app.timer.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import dev.spring.app.task.entity.Task
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "timers")
data class Timer (
    @Id
    @GeneratedValue
    val id: UUID = UUID.randomUUID(),
    val start: Instant = Instant.now(),
    val end: Instant? = null,
    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    @JsonBackReference
    val task: Task
) {
    constructor() : this(UUID.randomUUID(), Instant.now(), Instant.now(), Task())
}