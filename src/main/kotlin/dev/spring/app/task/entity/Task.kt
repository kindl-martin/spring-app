package dev.spring.app.task.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import dev.spring.app.timer.entity.Timer
import dev.spring.app.user.entity.User
import jakarta.persistence.*
import java.time.Instant

import java.util.*

@Entity
@Table(name = "tasks")
data class Task(
    @Id
    @GeneratedValue
    val id: UUID = UUID.randomUUID(),
    @Column(nullable = false, columnDefinition = "TEXT")
    val name: String,
    @ManyToOne
    val user: User,
    @Column(nullable = false)
    val createdAt: Instant = Instant.now(),
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "TEXT")
    val state: TaskState = TaskState.OPEN,
    @Column(nullable = false)
    val position: Int,
    val deletedAt: Instant? = null,
    @OneToMany(mappedBy = "task", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonManagedReference
    val timers: List<Timer> = emptyList()

) {
    @get:Transient
    val totalDuration: Long
        get() = timers.sumOf {
            if(it.end != null) {
                it.end.toEpochMilli() - it.start.toEpochMilli()
            } else 0L
        }

    constructor() : this(UUID.randomUUID(), "", User(), Instant.now(), TaskState.OPEN, 0)
}

enum class TaskState {
    OPEN,
    DONE
}